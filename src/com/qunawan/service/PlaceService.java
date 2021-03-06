package com.qunawan.service;

import java.util.List;
import java.util.Map;

import com.qunawan.entity.Place;

public interface PlaceService {
	List<Place> getPlaceByName(String name);
	List<String> getPagePlacesByType(int id ,int start, int maxCount);
	Place getPlaceById(int id);
}
