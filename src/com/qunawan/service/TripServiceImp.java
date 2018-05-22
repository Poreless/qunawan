package com.qunawan.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qunawan.bean.SearchBean;
import com.qunawan.dao.CityDao;
import com.qunawan.dao.PlaceDao;
import com.qunawan.dao.SequenceDao;
import com.qunawan.dao.ThemeDao;
import com.qunawan.dao.TripDao;
import com.qunawan.entity.*;
import com.qunawan.form.SearchForm;
import com.qunawan.utils.Utils;

@Service
public class TripServiceImp implements TripService{
	
	private List<Trip> allTripList = new ArrayList<>();
	private TripDao tripDao;
	private SequenceDao sequenceDao;
	private CityDao cityDao;
	private PlaceDao placeDao;
	private ThemeDao themeDao;
	
	@Resource(name="themeDaoImp")
	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}

	@Resource(name="placeDaoImp")
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

	@Resource(name="cityDaoImp")
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Resource(name="sequenceDaoImp")
	public void setSequenceDao(SequenceDao sequenceDao) {
		this.sequenceDao = sequenceDao;
	}
	
	public TripDao getTripDao() {
		return tripDao;
	}

	@Resource(name="tripDaoImp")
	public void setTripDao(TripDao tripDao) {
		this.tripDao = tripDao;
	}

	@Transactional
	public List<Trip> getPageTripsByType(int id, int start, int maxCount) {
		// TODO Auto-generated method stub
		return tripDao.getPageTripsByType(id, start, maxCount);
	}

	@Transactional
	public Trip getTripById(int id) {
		// TODO Auto-generated method stub
		return tripDao.getTripById(id);
	}

	@Transactional
	public Detail getDetail(int id) {
		// TODO Auto-generated method stub
		return tripDao.getDetail(id);
	}

	@Transactional
	public SearchBean getSearchBean(SearchForm vo) {
		// TODO Auto-generated method stub
		allTripList=new ArrayList<Trip>();
		SearchBean bean = new SearchBean(vo, allTripList);
		return bean;
	}

	@Transactional
	public List<Trip> getSearchTripsByVo(SearchForm vo) {
		// TODO Auto-generated method stub
		packageForm(vo);
		allTripList = tripDao.getAllTripByCondition(vo);
		return tripDao.getPageTripByCondition(vo, vo.getFistResult(), vo.getMaxResult());
	}
	
	private void packageForm(SearchForm vo) {
		// 如果行程类型字符串不为空，获取该行程类型的id
		if (vo.getType_name() != null) {
			String typename = vo.getType_name();
			Sequence s = sequenceDao.getSeqByValue(typename);
			if (s == null) {
				typename = Utils.isoToUtf(typename);
				vo.setType_name(typename);
				s = sequenceDao.getSeqByValue(typename);
			}
			vo.setType_id(s.getId());
		}
		// 如果出发地字符串不为空，获取该出发地的id
		if (vo.getStart_place_name() != null) {
			List<City> citys = cityDao.getCityByName(vo.getStart_place_name());
			List<Integer> cidList = new ArrayList<>();
			if (citys != null) {
				for(City city : citys){
					cidList.add(city.getId());
				}
			}
			vo.setStart_place_id_list(cidList);
		}
		// 如果景点地区字符串不为空，获取该景点地区的id
		if (vo.getPlace_name() != null) {
			List<Place> pList = placeDao.getPlaceByName(vo.getPlace_name());
			List<Integer> pidList = new ArrayList<>();
			if (pList != null && !pList.isEmpty()) {
				for (Place p : pList) {
					pidList.add(p.getId());
				}
			}
			vo.setPlace_id_list(pidList);
		}
		// 如果主题字符串不为空，获取该主题的id
		if (vo.getTheme_name() != null) {
			List<Theme> tList = themeDao.getThemeByName(vo.getTheme_name());
			List<Integer> tidList = new ArrayList<>();
			if (tList != null && !tList.isEmpty()) {
				for (Theme t : tList) {
					tidList.add(t.getId());
				}
			}
			vo.setTheme_id_list(tidList);
		}
	}

	@Transactional
	public List<Comment> getComment(int id) {
		// TODO Auto-generated method stub
		return tripDao.getComment(id);
	}
	
}
