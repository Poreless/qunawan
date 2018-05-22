package com.qunawan.dao;

import java.util.List;

import com.qunawan.entity.Comment;
import com.qunawan.entity.Detail;
import com.qunawan.entity.Trip;
import com.qunawan.form.SearchForm;

public interface TripDao {
	List<Trip> getAllTripByCondition(SearchForm vo);
	List<Trip> getPageTripByCondition(SearchForm vo, Integer start, Integer maxCount);
	List<Trip> getPageTripsByType(int id, int start, int maxCount);
	Trip getTripById(int id);
	public Detail getDetail(int id);
	public List<Comment> getComment(int id);
//	void updateScore(Trip trip, Connection con);
}
