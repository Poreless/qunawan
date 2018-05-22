package com.qunawan.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qunawan.entity.Place;
import com.qunawan.entity.Trip;
import com.qunawan.entity.User;
import com.qunawan.globle.Constants;
import com.qunawan.globle.Globle;
import com.qunawan.service.PlaceService;
import com.qunawan.service.SequenceService;
import com.qunawan.service.ThemeService;
import com.qunawan.service.TripService;
//import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{
	private PlaceService ps;
	private SequenceService ss;
	private TripService ts;
	private ThemeService themeService;
	public ThemeService getThemeService() {
		return themeService;
	}
	@Resource(name="themeServiceImp")
	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}
	private Map<String, List<String>> placeMap = new HashMap<>();
	private Map<String, List<Trip>> tripMap = new HashMap<>();
	private Map<String, List<String>> themeMap = new HashMap<>();
	

	private static final long serialVersionUID = 1L;
	private String[] tripTypes = Constants.TRIP_TYPE;

	public Map<String, List<String>> getPlaceMap() {
		return placeMap;
	}
	public void setPlaceMap(Map<String, List<String>> placeMap) {
		this.placeMap = placeMap;
	}
	

	public PlaceService getPs() {
		return ps;
	}
	@Resource(name="placeServiceImp")
	public void setPs(PlaceService ps) {
		this.ps = ps;
	}
	public SequenceService getSs() {
		return ss;
	}
	@Resource(name="sequenceServiceImp")
	public void setSs(SequenceService ss) {
		this.ss = ss;
	}
	public TripService getTs() {
		return ts;
	}
	@Resource(name="tripServiceImp")
	public void setTs(TripService ts) {
		this.ts = ts;
	}
	@Override
	public String execute() throws Exception {
		for (int i = 0; i < 3; i++) {
			int typeId = ss.getSeqByValue(tripTypes[i]).getId();
			tripMap.put(tripTypes[i], ts.getPageTripsByType(typeId, 0, 6));
			placeMap.put(tripTypes[i], ps.getPagePlacesByType(typeId, 0, 10));
			themeMap.put(tripTypes[i], themeService.getPageThemesByType(typeId, 0, 10));
		}

		ActionContext.getContext().getSession().put(Constants.INDEX_TRIP_MAP, tripMap);
		ActionContext.getContext().getSession().put(Constants.INDEX_PLACE_MAP, placeMap);
		ActionContext.getContext().getSession().put(Constants.INDEX_THEME_MAP, themeMap);
		
		if (ActionContext.getContext().getSession().get(Constants.USER_KEY) != null) {

			Integer uid = ((User)ActionContext.getContext().getSession().get(Constants.USER_KEY)).getId();
	
			Globle.addAccessRecord(uid, Constants.INDEX_PAGE);
		}

		
		return "success";
	}
}
