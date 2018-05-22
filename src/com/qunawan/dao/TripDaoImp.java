package com.qunawan.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.qunawan.entity.Comment;
import com.qunawan.entity.Detail;
import com.qunawan.entity.Placeontrip;
import com.qunawan.entity.Trip;
import com.qunawan.entity.Trippicture;
import com.qunawan.form.SearchForm;
import com.qunawan.utils.Packager;

@Repository
public class TripDaoImp implements TripDao{

	private SessionFactory sessionFacotry;
	
	@Resource(name="sessionFactory")
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		this.sessionFacotry = sessionFacotry;
	}

	public Session getSession(){
		return sessionFacotry.getCurrentSession();
	}
	
	@Override
	public List<Trip> getPageTripsByType(int id, int start, int maxCount) {
		// TODO Auto-generated method stub
		String hql = "FROM Trip t WHERE t.sequence.id = ? order by t.goodRate";
		List<Trip> ts=getSession().createQuery(hql).setParameter(0, id).list();
		List<Trip> t=new ArrayList<Trip>();
		for(int i=start;i<start+maxCount&&i<ts.size();i++){
			if(!t.contains(ts.get(i)))
				t.add(ts.get(i));
			else
				maxCount++;
		}
		return t;
	}

	@Override
	public Trip getTripById(int id) {
		// TODO Auto-generated method stub
		String hql = "FROM Trip t WHERE t.id = ?";
		return (Trip) getSession().createQuery(hql).setParameter(0, id).uniqueResult();
	}

	@Override
	public Detail getDetail(int id) {
		// TODO Auto-generated method stub
		String hql="from Detail d where d.trip.id=?";
		return (Detail) getSession().createQuery(hql).setParameter(0, id).uniqueResult();
	}
	
	@Override
	public List<Comment> getComment(int id) {
		// TODO Auto-generated method stub
		String hql="from Comment c where c.trip.id=?";
		return getSession().createQuery(hql).setParameter(0, id).list();
	}

	@Override
	public List<Trip> getAllTripByCondition(SearchForm vo) {
		// TODO Auto-generated method stub
		return getPageTripByCondition(vo, null, null);
	}

	@Override
	public List<Trip> getPageTripByCondition(SearchForm vo, Integer start,
			Integer maxCount) {
		// TODO Auto-generated method stub
		String sql = getBaseSql(vo);
		List<Object[]> list=getSession().createSQLQuery(sql).list();
		List<Trip> tlist=new ArrayList<Trip>();
		if (list != null) {
			for(int i=0;i<list.size();i++){
				Object[] o=(Object[]) list.get(i);
				tlist.add((Trip) getSession().get(Trip.class, (int)o[0])); 
			}
		}  
		return tlist;
	}
	
	private String getBaseSql(SearchForm vo) {
		
		String sql = "SELECT distinct t.*, (SELECT min(price) FROM Price WHERE trip=t.id) AS price_sort FROM Trip t,Price p WHERE t.id=p.trip AND t.is_ok=1";

		if (vo.getType_id() != null) {
			sql += " AND t.type=" + vo.getType_id();
		}
		List<Integer> startList = vo.getStart_place_id_list();
		if (startList != null && !startList.isEmpty()) {
			sql += " AND (t.start_place=" + startList.get(0);
			for (int i = 1; i < startList.size(); i++) {
				sql += " OR t.start_place=" + startList.get(i);
			}
			sql += ")";
		}


		if (vo.getTraffic() != null) {
			sql += " AND t.traffic LIKE '%" + vo.getTraffic() + "%'";
		}


		if (vo.getTime() != null) {
			sql += " AND t.time=" + vo.getTime();
		}
		
		if (vo.getSearch_key() != null) {
			sql += " AND (t.id IN (" + "SELECT tot.trip FROM ThemeOnTrip tot WHERE tot.theme IN ("
					+ "SELECT th.id FROM Theme th WHERE th.name LIKE '%" + vo.getSearch_key() + "%'))" + "OR t.id IN ("
					+ "SELECT pot.trip FROM PlaceOnTrip pot WHERE pot.place IN ("
					+ "SELECT p.id FROM Place p WHERE p.name LIKE '%" + vo.getSearch_key() + "%'))" + "OR t.title LIKE '%"
					+ vo.getSearch_key() + "%' " + "OR t.s_title LIKE '%" + vo.getSearch_key() + "%')";
		}
		

		List<Integer> placeList = vo.getPlace_id_list();
		if (placeList != null && !placeList.isEmpty()) {
			sql += " AND t.id IN (SELECT pt.trip FROM PlaceOnTrip pt WHERE (pt.place=" + placeList.get(0);
			for (int i = 1; i < placeList.size(); i++) {
				sql += " OR pt.place=" + placeList.get(i);
			}
			sql += "))";
		}


		List<Integer> themeList = vo.getTheme_id_list();
		if (themeList != null && !themeList.isEmpty()) {
			sql += " AND t.id IN (SELECT tt.trip FROM ThemeOnTrip tt WHERE (tt.theme=" + themeList.get(0);
			for (int i = 1; i < themeList.size(); i++) {
				sql += " OR tt.theme=" + themeList.get(i);
			}
			sql += "))";
		}


		if (vo.getMin_price() != null) {
			sql += " AND t.id IN (SELECT p.trip FROM Price p where p.price>=" + vo.getMin_price() + ")";
		}

		if (vo.getMax_price() != null) {
			sql += " AND t.id IN (SELECT p.trip FROM Price p where p.price<=" + vo.getMax_price() + ")";
		}
		

		if (vo.getGood_rate_sort() == null && vo.getPrice_sort() == null)
			sql += " ORDER BY t.good_rate desc,price_sort asc";


		if (vo.getCur_sort_str() != null && "price".equals(vo.getCur_sort_str())) {
			if (vo.getGood_rate_sort() != null)
				sql += " ORDER BY price_sort " + vo.getPrice_sort() + ",t.good_rate " + vo.getGood_rate_sort();
			else
				sql += " ORDER BY price_sort " + vo.getPrice_sort() + ",t.good_rate desc";
		}


		if (vo.getCur_sort_str() != null && "comment".equals(vo.getCur_sort_str())) {
			if (vo.getPrice_sort() != null)
				sql += " ORDER BY t.good_rate " + vo.getGood_rate_sort() + ",price_sort " + vo.getPrice_sort();
			else
				sql += " ORDER BY t.good_rate " + vo.getGood_rate_sort() + ",price_sort asc";
		}

		return sql;
	}

}
