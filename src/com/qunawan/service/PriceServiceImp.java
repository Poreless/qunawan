package com.qunawan.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qunawan.dao.PriceDao;
import com.qunawan.entity.Price;

@Service
public class PriceServiceImp implements PriceService{
	
	private PriceDao priceDao;
	
	@Resource(name="priceDaoImp")
	public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}
	@Override
	public Price getOneDayPrice(Integer tripId, Date time) {
		// TODO Auto-generated method stub
		return priceDao.getOneDayPrice(tripId, time);
	}

	@Override
	public List<Price> getPricesByTripId(Integer tripId) {
		// TODO Auto-generated method stub
		return priceDao.getPricesByTripId(tripId);
	}

}
