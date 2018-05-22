package com.qunawan.service;

import java.util.List;

import com.qunawan.entity.Theme;

public interface ThemeService {
	public List<String> getPageThemesByType(int id, int start, int maxCount);
	public List<Theme> getThemeByName(String name);
}
