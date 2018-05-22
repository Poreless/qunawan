package com.qunawan.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qunawan.entity.City;
import com.qunawan.entity.User;
import com.qunawan.globle.Constants;
import com.qunawan.service.CityService;
import com.qunawan.service.UserService;
import com.qunawan.utils.Utils;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport{
	
	private User user;
	private UserService us;
	private CityService cityService;
	public String name;// 用户提交的手机或邮箱
	public String password; // 用户的个人密码
	public String code;// 用户输入的验证码
	public String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CityService getCityService() {
		return cityService;
	}
	@Resource(name="cityServiceImp")
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}
	public UserService getUs() {
		return us;
	}
	@Resource(name="userServiceImp")
	public void setUs(UserService us) {
		this.us = us;
	}
	
	//execute
/*	public String execute(){
		
		System.out.println("执行了登录execute的方法");
	
		// 通过用户名查询用户
		User u = us.getUserByCondition(name);
		
		if(name == null || password == null || code == null || code.equals("")){
			
			System.out.println("name是："+name+"password是："+password+"code是："+code);
			
			return "loginFail";
		}
		// session域中拿到当前正确的验证码
		String right_code = (String) ActionContext.getContext().getSession().get(Constants.CHECK_NUMBER_NAME);
		if(right_code != null){
			
			System.out.println("right_code等于："+right_code);
			
			if(!us.checkCode(right_code, code)){
				ActionContext.getContext().getSession().put(Constants.ERROR, "验证码不正确");
			    return "loginFail";
			}
		}
		// 如果用户名、密码或者验证码为空则跳转回登录页面
		if(u == null || !u.getPassword().equals(Utils.toMD5(password))){
			
			ActionContext.getContext().getSession().put(Constants.ERROR, "用户名或密码错误");
			return "loginFail";
			
		}
		else {
			
			System.out.println("User为"+u.getPhone()+" "+u.getEmail()+" "+u.getPassword());
			
			ActionContext.getContext().getSession().put("user", u);
			return "loginSuc";
		}
	}*/
/*	public String login(){	
		// 通过用户名查询用户
		User u = us.getUserByCondition(name);
		
		if(name == null || password == null || code == null || code.equals("")){
			
			System.out.println("Name是："+name+" Password是："+password+" code是："+code);
			
			return "fail";
		}
		// session域中拿到当前正确的验证码
		String right_code = (String) ActionContext.getContext().getSession().get(Constants.CHECK_NUMBER_NAME);
		if(right_code != null){
			
			System.out.println("right_code等于："+right_code);
			
			if(!us.checkCode(right_code, code)){
				ActionContext.getContext().getSession().put(Constants.ERROR, "验证码不正确");
			    return "fail";
			}
		}
		// 如果用户名、密码或者验证码为空则跳转回登录页面
		if(u == null || !u.getPassword().equals(Utils.toMD5(password))){			
			ActionContext.getContext().getSession().put(Constants.ERROR, "用户名或密码错误");
			return "fail";			
		}
		else {			
			System.out.println("User为"+u.getPhone()+" "+u.getEmail()+" "+u.getPassword());		
			ActionContext.getContext().getSession().put("user", u);
			return "loginSuc";
		}
	}*/
	public String login(){
		String ident=ServletActionContext.getRequest().getParameter("code");
		String code=(String) ActionContext.getContext().getSession().get(Constants.CHECK_NUMBER_NAME);
		if(!ident.equalsIgnoreCase(code)){
			ActionContext.getContext().getSession().put("message", "验证码不正确");
			return "fail";
		}
		User u=us.login(user);
		if(u!=null){
			user=u;
			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession().put(Constants.USER_KEY, user);
			System.out.println("Login Success!");
			return "loginSuc";
		}else{
			ActionContext.getContext().getSession().put("message", "用户名或密码不正确");
			return "fail";
		}
	}
	
	public String register(){
		user.setPassword(Utils.toMD5("123456"));
		if(us.register(user)){
			ActionContext.getContext().getSession().clear();
			ActionContext.getContext().getSession().put(Constants.USER_KEY, user);
			return "registerSuc";
		}
		else{
			ActionContext.getContext().getSession().put("message", "用户名已存在");
			return "fail";
		}
	}
/*	public String register(){
		setType(type);
		if("init".equals(type)){
			ActionContext.getContext().getSession().put("init", "reg");
		}
		else {
			if(isUserExisted(name)){
				ActionContext.getContext().getSession().put(Constants.ERROR, "当前注册帐号已存在");
				ActionContext.getContext().getSession().put("init", "reg");
			}
			else {
				
				us.registUser(name);
				return "registerSuc";
			}
		}
		return "fail";
	}*/
	private boolean isUserExisted(String condition) {
		
		User u = us.getUserByCondition(condition);
		// 对注册帐号的唯一性进行验证
		if (u != null) {
			return true;
		}
		return false;
	}
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logoutSuc";
	}
	
	public String prepareInfo(){
		if(ActionContext.getContext().getSession().get("user")==null){
			ActionContext.getContext().getSession().put("message", "请登录");
			return "fail";
		}
		List<City> clist=cityService.getCity(1);
		ActionContext.getContext().getSession().put("provinces", clist);
		return "preInfoSuc";
	}

	public String preparePwd(){
		if(ActionContext.getContext().getSession().get("user")==null){
			ActionContext.getContext().getSession().put("message", "请登录");
			return "fail";
		}
		return "prePwdSuc";
	}
	
	public String updateInfo(){
		Short sex=Short.parseShort(ServletActionContext.getRequest().getParameter("sex"));
		user.setSex(sex);
		int sel_year=Integer.parseInt(ServletActionContext.getRequest().getParameter("sel_year"));
		int sel_month=Integer.parseInt(ServletActionContext.getRequest().getParameter("sel_month"));
		int sel_day=Integer.parseInt(ServletActionContext.getRequest().getParameter("sel_day"));
		Date date=new Date(sel_year, sel_month, sel_day);
		user.setBirthday(date);
		User u_old=(User) ActionContext.getContext().getSession().get("user");
		
		return "updateInfoSuc";
	}
	
	public String updatePwd(){
		String oldPassWord=ServletActionContext.getRequest().getParameter("oldPassWord");
		String newPassWord=ServletActionContext.getRequest().getParameter("newPassWord");
		String newPassWordt=ServletActionContext.getRequest().getParameter("newPassWordt");
		if(!newPassWord.equals(newPassWordt)){
			ActionContext.getContext().getSession().put("err_msg", "两次输入的密码不同ͬ");
			return "updatePwdFail";
		}
		User u=us.updatePwd((User)ActionContext.getContext().getSession().get("user"), oldPassWord, newPassWord);
		if(u==null){
			ActionContext.getContext().getSession().put("err_msg", "密码更新失败");
			return "updatePwdFail";
		}	
		ActionContext.getContext().getSession().put("err_msg", "密码更新成功");
		return "updatePwdSuc";
	}
	
	public String prepareOrder(){
		if(ActionContext.getContext().getSession().get("user")==null){
			ActionContext.getContext().getSession().put("message", "请登录");
			return "fail";
		}
		return "preOrderSuc";
	}
	
	public String prepareComment(){
		User u=(User) ActionContext.getContext().getSession().get("user");
		if(u==null){
			ActionContext.getContext().getSession().put("message", "请登录");
			return "fail";
		}
		List clist=us.getCommentByUid(u.getId());
		ActionContext.getContext().getSession().put("myComment", clist);
		return "preComSuc";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}