package com.qunawan.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qunawan.bean.SearchBean;
import com.qunawan.entity.Comment;
import com.qunawan.entity.Detail;
import com.qunawan.entity.Trip;
import com.qunawan.entity.User;
import com.qunawan.form.SearchForm;
import com.qunawan.globle.Constants;
import com.qunawan.globle.Globle;
import com.qunawan.service.TripService;
//import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

@Controller("tripAction")
@Scope("prototype")
public class TripAction extends ActionSupport{
	
	private TripService tripService;
	
	
	public TripService getTripService() {
		return tripService;
	}
	@Resource(name="tripServiceImp")
	public void setTripService(TripService tripService) {
		this.tripService = tripService;
	}

	public String showDetail(){
		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Detail detail=tripService.getDetail(id);
		List<Comment> comment=tripService.getComment(id);
		ActionContext.getContext().getSession().put("detail", detail);
		ActionContext.getContext().getSession().put("comment", comment);
		ActionContext.getContext().getSession().put("num", comment.size());
		return "showDetailSuc";
	}
	
	public String searchTrip(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String type = request.getParameter("triptype"); 
		String place = request.getParameter("place"); 
		String start_place = request.getParameter("start_place"); 
		String theme = request.getParameter("theme"); 
		String traffic = request.getParameter("traffic"); 
		String time_str = request.getParameter("time"); 
		String min_price_str = request.getParameter("min_price"); 
		String max_price_str = request.getParameter("max_price"); 

		String price_sort = request.getParameter("price_sort"); 
		String good_rate_sort = request.getParameter("good_rate_sort"); 
		String cur_sort_str = request.getParameter("cur_sort_str"); 

		String search_key = request.getParameter("search_key"); 

		String pageCurrent_str = request.getParameter("pageCurrent"); 

		type = transString(type);
		place = transString(place);
		start_place = transString(start_place);
		theme = transString(theme);
		traffic = transString(traffic);
		price_sort = transString(price_sort);
		good_rate_sort = transString(good_rate_sort);
		cur_sort_str = transString(cur_sort_str);
		search_key = transString(search_key);


		Integer time;
		Integer min_price;
		Integer max_price;
		Integer pageCurrent;
		try {
			time = Integer.parseInt(time_str);
		} catch (Exception e) {
			time = null;
		}
		try {
			min_price = Integer.parseInt(min_price_str);
		} catch (Exception e) {
			min_price = null;
		}
		try {
			max_price = Integer.parseInt(max_price_str);
		} catch (Exception e) {
			max_price = null;
		}
		try {
			pageCurrent = Integer.parseInt(pageCurrent_str);
		} catch (Exception e) {
			pageCurrent = 1;
		}

	
		SearchForm vo = new SearchForm(type, place, start_place, theme, traffic, time, min_price, max_price,
				pageCurrent, price_sort, good_rate_sort, cur_sort_str, search_key);

		
		List<Trip> list = tripService.getSearchTripsByVo(vo);
		
		SearchBean bean = tripService.getSearchBean(vo);


//		for (Trip t : list) {
//			tripService.initTripPicture(t.getPic_list(), getServletConfig().getServletContext().getRealPath("/"));
//		}

		request.getSession().setAttribute(Constants.SEARCH_LIST, list);
		ActionContext.getContext().getSession().put("count", list.size());
		ActionContext.getContext().getSession().put("key", search_key);
		ActionContext.getContext().getSession().put("page", pageCurrent);
		request.getSession().setAttribute(Constants.SEARCH_BEAN, bean);

	
		if (request.getSession().getAttribute(Constants.USER_KEY) != null) {
		
			User user = (User) request.getSession().getAttribute(Constants.USER_KEY);
			Globle.addAccessRecord(user.getId(), Constants.SEARCH_PAGE);
		}
		
		return "searchSuc";
	}
	
	private boolean isEmpty(String s) {
		return s == null || "".equals(s) ? true : false;
	}
	
	private String transString(String s) {
		if (isEmpty(s))
			return null;
		return s.trim();
	}
	
}
