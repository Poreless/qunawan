package com.qunawan.service;

import java.util.List;

import com.qunawan.entity.City;

public interface CityService {
	public List<City> getCity(int rank);
	public List<City> getCity(int pid,int rank);
	public List<City> getCityByName(String name);
}
