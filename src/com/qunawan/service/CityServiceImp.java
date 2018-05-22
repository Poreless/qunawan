package com.qunawan.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qunawan.dao.CityDao;
import com.qunawan.entity.City;

@Service
public class CityServiceImp implements CityService{

	private CityDao cityDao;
	
	@Resource(name="cityDaoImp")
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Transactional
	public List<City> getCity(int rank) {
		// TODO Auto-generated method stub
		return cityDao.getCity(rank);
	}

	@Transactional
	public List<City> getCityByName(String name) {
		// TODO Auto-generated method stub
		return cityDao.getCityByName(name);
	}

	@Override
	public List<City> getCity(int pid, int rank) {
		// TODO Auto-generated method stub
		return cityDao.getCity(pid, rank);
	}

}
