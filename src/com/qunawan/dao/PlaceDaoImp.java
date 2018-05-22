package com.qunawan.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.Place;
import com.qunawan.entity.Placeontrip;
import com.qunawan.entity.Trip;

@Repository
public class PlaceDaoImp implements PlaceDao{
	
	private SessionFactory sessionFacotry;
	
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}

	@Override
	public List<Place> getPlaceByName(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM Place p WHERE p.name = ?";
		return getSession().createQuery(hql).setParameter(0, name).list();
	}

	@Override
	public List<String> getPagePlacesByType(int id, int start, int maxCount) {
		// TODO Auto-generated method stub
		String hql="from Trip t where t.sequence.id=? order by t.placeScore";
		List<Trip> ts=getSession().createQuery(hql).setParameter(0, id).list();
		List<String> list=new ArrayList<String>();
		for(int i=start;i<start+maxCount&&i<ts.size();i++){
			String name=ts.get(i).getPlaceontrips().iterator().next().getPlace().getName();
			if(!list.contains(name))
				list.add(name);
			else
				maxCount++;
		}
		return list;
	}

	@Override
	public Place getPlaceById(int id) {
		// TODO Auto-generated method stub
		String hql = "FROM Place p WHERE p.id = ?";	
		return (Place) getSession().createQuery(hql).setParameter(0, id).uniqueResult();
	}
	
	
}
