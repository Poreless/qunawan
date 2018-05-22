package com.qunawan.globle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.qunawan.utils.UserAccessRecorder;


public class Globle {

	private static HashMap<Integer, List<byte[]>> comPicCache = new HashMap<Integer, List<byte[]>>();


	private static Map<Integer, UserAccessRecorder> userAccessMap = new HashMap<>();


	public static void uploadPics(Integer uuid, byte[] pic) {
		List<byte[]> pics = comPicCache.get(uuid);
		if (pics == null) {
			pics = new ArrayList<byte[]>();
		}
		pics.add(pic);
		comPicCache.put(uuid, pics);
	}


	public static List<byte[]> getPics(Integer uuid) {
		if (comPicCache == null)
			return null;
		return comPicCache.get(uuid);
	}


	public static void clear(Integer uuid) {
		if (comPicCache == null)
			return;
		comPicCache.remove(uuid);
	}

	public static HashMap<Integer, List<byte[]>> getComPicCache() {
		return comPicCache;
	}

	public static void setComPicCache(HashMap<Integer, List<byte[]>> comPicCache) {
		Globle.comPicCache = comPicCache;
	}


	public static void addAccessRecord(Integer uid, String page) {
		UserAccessRecorder recorder = Globle.userAccessMap.get(uid);
		if (recorder == null) {
			Globle.userAccessMap.put(uid, new UserAccessRecorder());
			recorder = Globle.userAccessMap.get(uid);
		}
		recorder.setAccessMap(page);
	}

	public static void clearAccessRecorder(Integer uid) {
		Globle.userAccessMap.remove(uid);
	}


	public static List<Map.Entry<String, String>> getAccessList(Integer uid) {
		UserAccessRecorder recorder = Globle.userAccessMap.get(uid);
		if (recorder == null) {
			Globle.userAccessMap.put(uid, new UserAccessRecorder());
			recorder = Globle.userAccessMap.get(uid);
		}
		return recorder.getAccessList();
	}
	


	public static Map<String, HttpSession> loginSessionMap = new HashMap<String, HttpSession>();
}
