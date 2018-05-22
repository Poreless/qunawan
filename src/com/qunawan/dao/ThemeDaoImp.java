package com.qunawan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.Theme;
import com.qunawan.entity.Trip;

@Repository
public class ThemeDaoImp implements ThemeDao{

	private SessionFactory sessionFacotry;
	
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}
	
	@Override
	public List<String> getPageThemesByType(int id, int start, int maxCount) {
		// TODO Auto-generated method stub
		String hql="from Trip t where t.sequence.id=? order by t.serviceScore";
		List<Trip> ts=getSession().createQuery(hql).setParameter(0, id).list();
		List<String> list=new ArrayList<String>();
		for(int i=start;i<start+maxCount&&i<ts.size();i++){
			String theme=ts.get(i).getThemeontrips().iterator().next().getTheme().getName();
			if(!list.contains(theme))
				list.add(theme);
			else
				maxCount++;
		}
		return list;
	}

	@Override
	public List<Theme> getThemeByName(String name) {
		// TODO Auto-generated method stub
		String hql="from Theme t where t.name=?";
		return getSession().createQuery(hql).setParameter(0, name).list();
	}

}
