package com.qunawan.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qunawan.dao.UserDao;
import com.qunawan.entity.Comment;
import com.qunawan.entity.User;
import com.qunawan.utils.Utils;


@Service
public class UserServiceImp implements UserService{
	
	private UserDao userDao;
	
	@Resource(name="userDaoImp")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Transactional
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return userDao.register(user);
	}

	@Transactional
	public User updatePwd(User u, String old_pwd, String new_pwd) {
		// TODO Auto-generated method stub
		return userDao.updatePwd(u, old_pwd, new_pwd);
	}

	@Transactional
	public List<Comment> getCommentByUid(int id) {
		// TODO Auto-generated method stub
		return userDao.getCommentByUid(id);
	}

	@Transactional
	public User updateInfo(User u_old, User u_new) {
		// TODO Auto-generated method stub
		return userDao.updateInfo(u_old, u_new);
	}

	@Transactional
	public User getUserByCondition(String condition) {
		// TODO Auto-generated method stub
		return userDao.getUserByCondition(condition);
	}

	@Transactional
	public void registUser(String condition) {
		// TODO Auto-generated method stub
		User user = new User();
		if(Utils.isEmail(condition)){
			user.setEmail(condition);
		}
		else {
			user.setPhone(condition);
		}
		user.setPassword(Utils.toMD5("123456"));
		userDao.save(user);
	}

	@Transactional
	public boolean checkCode(String right_code, String code) {
		// TODO Auto-generated method stub
		return userDao.checkCode(right_code, code);
	}

	@Transactional
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
		
	}
	
}
