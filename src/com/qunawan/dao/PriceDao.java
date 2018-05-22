package com.qunawan.dao;

import java.util.Date;
import java.util.List;

import com.qunawan.entity.Price;

public interface PriceDao {
	Price getOneDayPrice(Integer tripId, Date time);
	List<Price> getPricesByTripId(Integer tripId);
}
