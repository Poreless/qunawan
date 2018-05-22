package com.qunawan.service;

import java.util.List;

import com.qunawan.bean.SearchBean;
import com.qunawan.entity.Comment;
import com.qunawan.entity.Detail;
import com.qunawan.entity.Trip;
import com.qunawan.form.SearchForm;

public interface TripService {
//	List<Trip> getAllTripByCondition(SearchForm vo);
//	List<Trip> getPageTripByCondition(SearchForm vo, Integer start, Integer maxCount);
	List<Trip> getPageTripsByType(int id, int start, int maxCount);
	Trip getTripById(int id);
	public Detail getDetail(int id);
	public List<Comment> getComment(int id);
	SearchBean getSearchBean(SearchForm vo);
	List<Trip> getSearchTripsByVo(SearchForm vo);
//	void updateScore(Trip trip, Connection con);
}
