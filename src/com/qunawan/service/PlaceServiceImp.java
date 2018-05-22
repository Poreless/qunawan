package com.qunawan.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qunawan.dao.PlaceDao;
import com.qunawan.entity.Place;

@Service
public class PlaceServiceImp implements PlaceService{
	private PlaceDao placeDao;
	
	@Resource(name="placeDaoImp")
	public void setPlaceDao(PlaceDao placeDao) {
		this.placeDao = placeDao;
	}

	@Transactional
	public List<Place> getPlaceByName(String name) {
		// TODO Auto-generated method stub
		return placeDao.getPlaceByName(name);
	}


	@Transactional
	public List<String> getPagePlacesByType(int id, int start, int maxCount) {
		// TODO Auto-generated method stub
		return placeDao.getPagePlacesByType(id, start, maxCount);
	}


	@Transactional
	public Place getPlaceById(int id) {
		// TODO Auto-generated method stub
		return placeDao.getPlaceById(id);
	}

}
