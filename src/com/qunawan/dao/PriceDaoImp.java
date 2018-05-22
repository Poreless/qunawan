package com.qunawan.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.Price;
import com.qunawan.utils.Packager;

@Repository
public class PriceDaoImp implements PriceDao{

	private SessionFactory sessionFacotry;
	
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}
	
	@Override
	public Price getOneDayPrice(Integer tripId, Date time) {
		// TODO Auto-generated method stub
		String hql = "FROM Price p WHERE p.trip = ? AND p.date = ?";
		return (Price) getSession().createQuery(hql).setParameter(0, tripId).setParameter(1, time).uniqueResult();
	}

	@Override
	public List<Price> getPricesByTripId(Integer tripId) {
		// TODO Auto-generated method stub
		String hql = "SELECT * FROM Price p WHERE p.trip = ?";
		return getSession().createQuery(hql).setParameter(0, tripId).list();
	}

}
