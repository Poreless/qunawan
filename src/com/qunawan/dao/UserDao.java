package com.qunawan.dao;

import java.util.List;

import com.qunawan.entity.Comment;
import com.qunawan.entity.User;

public interface UserDao {
	public User login(User user);
	public boolean register(User user);
	public User updateInfo(User u_old,User u_new);
	public User updatePwd(User u,String old_pwd,String new_pwd);
	public List<Comment> getCommentByUid(int id);
	User getUserByCondition(String condition);
	boolean checkCode(String right_code, String code);
	void save(User user);
}
