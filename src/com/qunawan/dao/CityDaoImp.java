package com.qunawan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.City;

@Repository
public class CityDaoImp implements CityDao{

	private SessionFactory sessionFacotry;
	
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}

	@Override
	public List<City> getCity(int rank) {
		// TODO Auto-generated method stub
		String hql="from City c where c.type=?";
		return getSession().createQuery(hql).setParameter(0, rank).list();
	}

	@Override
	public List<City> getCityByName(String name) {
		// TODO Auto-generated method stub
		String hql="from City c where c.name=?";
		return getSession().createQuery(hql).setParameter(0, name).list();
	}

	@Override
	public List<City> getCity(int pid, int rank) {
		// TODO Auto-generated method stub
		String hql="select id,name from City c where c.type=? and c.city.id=?";
		List<Object> list=getSession().createQuery(hql).setParameter(0, rank).setParameter(1, pid).list();
		List<City> clist=new ArrayList<City>();
		for(int i=0;i<list.size();i++){
			Object[] o=(Object[]) list.get(i);
			City c=new City();
			c.setId((int)o[0]);
			c.setName((String)o[1]);
			clist.add(c);
		}
		return clist;
	}

}
