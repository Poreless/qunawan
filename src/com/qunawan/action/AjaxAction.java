package com.qunawan.action;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONString;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qunawan.entity.City;
import com.qunawan.service.CityService;

@Controller("ajaxAction")
@Scope("prototype")
public class AjaxAction extends ActionSupport{
	private CityService cityService;
	private String data;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public CityService getCityService() {
		return cityService;
	}
	@Resource(name="cityServiceImp")
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public String getCities(){
		int id=Integer.parseInt(ServletActionContext.getRequest().getParameter("province"));	
		List<City> clist=cityService.getCity(id,2);
		for(int i=0;i<clist.size();i++)
			System.out.println(clist.get(i).getId()+"  "+clist.get(i).getName());
		List<City> listtest=new ArrayList<City>();
		City c1=new City();
		c1.setId(0);
		c1.setName("·”÷›");
		City c2=new City();
		c2.setId(1);
		c2.setName("π»¿¥");
		listtest.add(c1);
		listtest.add(c2);
		setData(JSON.toJSONString(clist));
		System.out.println(data);
		
		return SUCCESS;
	}
}
