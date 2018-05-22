package com.qunawan.dao;

import java.util.List;

import com.qunawan.entity.City;

public interface CityDao {
	public List<City> getCity(int rank);
	public List<City> getCity(int pid,int rank);
	public List<City> getCityByName(String name);
}
