package com.qunawan.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.Comment;
import com.qunawan.entity.User;
import com.qunawan.utils.Utils;

@Repository
public class UserDaoImp implements UserDao{

	
	private SessionFactory sessionFacotry;
		
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone = ? and u.password = ?";
		User u = (User)getSession().createQuery(hql).setParameter(0, user.getPhone()).
				setParameter(1, Utils.toMD5(user.getPassword())).uniqueResult();		
		return u;
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.phone = ?";
		User u = (User)getSession().createQuery(hql).setParameter(0, user.getPhone()).uniqueResult();	
		if(u==null){
			user.setPassword(Utils.toMD5("123456"));
			getSession().save(user);
			getSession().update(user);
			return true;
		}
		else
			return false;
	}

	@Override
	public User updatePwd(User u, String old_pwd, String new_pwd) {
		// TODO Auto-generated method stub
		User user=(User) getSession().get(User.class, u.getId());
		if(!user.getPassword().equals(old_pwd))
			return null;
		user.setPassword(Utils.toMD5(new_pwd));
		getSession().update(user);
		return user;
	}

	@Override
	public List<Comment> getCommentByUid(int id) {
		// TODO Auto-generated method stub
		String hql = "from Comment c where c.user.id=?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

	@Override
	public User updateInfo(User u_old, User u_new) {
		// TODO Auto-generated method stub
		User u=(User) getSession().get(User.class, u_old.getId());
		u.setName(u_new.getName());
		u.setSex(u_new.getSex());
		u.setPhone(u_new.getPhone());
		u.setEmail(u_new.getEmail());
		
		return u;
	}

	@Override
	public User getUserByCondition(String condition) {
		// TODO Auto-generated method stub
		String hql = "FROM User u WHERE u.phone =:u_phone or u.email =:u_email";	
		return (User) getSession().createQuery(hql).setParameter("u_phone", condition).setParameter("u_email", condition).uniqueResult();
	}

	@Override
	public boolean checkCode(String right_code, String code) {
		// TODO Auto-generated method stub
		if (right_code == null || "".equals(right_code))
			return false;
		right_code =right_code.toUpperCase();
		code = code.toUpperCase();
		if (right_code.equals(code))
			return true;
		else
			return false;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(user);
		
	}
	
}
