package com.qunawan.service;

import java.util.Date;
import java.util.List;

import com.qunawan.entity.Price;

public interface PriceService {
	Price getOneDayPrice(Integer tripId, Date time);
	List<Price> getPricesByTripId(Integer tripId);
}
