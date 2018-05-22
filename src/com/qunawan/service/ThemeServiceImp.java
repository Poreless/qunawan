package com.qunawan.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.qunawan.dao.ThemeDao;
import com.qunawan.entity.Theme;

@Service
public class ThemeServiceImp implements ThemeService{

	private ThemeDao themeDao;
	
	@Resource(name="themeDaoImp")
	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}

	@Transactional
	public List<String> getPageThemesByType(int id, int start, int maxCount) {
		// TODO Auto-generated method stub
		return themeDao.getPageThemesByType(id, start, maxCount);
	}

	@Transactional
	public List<Theme> getThemeByName(String name) {
		// TODO Auto-generated method stub
		return themeDao.getThemeByName(name);
	}

}
