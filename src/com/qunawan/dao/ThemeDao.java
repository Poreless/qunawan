package com.qunawan.dao;

import java.util.List;

import com.qunawan.entity.Theme;

public interface ThemeDao {
	List<String> getPageThemesByType(int id,int start,int maxCount);
	public List<Theme> getThemeByName(String name);
}
