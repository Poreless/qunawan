package com.qunawan.form;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.qunawan.entity.City;
import com.qunawan.entity.Place;
import com.qunawan.entity.Placeontrip;
import com.qunawan.entity.Price;
import com.qunawan.entity.Sequence;
import com.qunawan.entity.Theme;
import com.qunawan.entity.Themeontrip;
import com.qunawan.entity.Trip;
import com.qunawan.entity.Trippicture;

public class SearchForm {

	private Integer type_id; 
	private String type_name; 
	private String place_name; 
	private String start_place_name;
	private List<Integer> place_id_list; 
	private List<Integer> start_place_id_list; 
	private List<Integer> theme_id_list; 
	private String theme_name; 
	private String traffic; 
	private Integer time; 
	private Integer min_price;
	private Integer max_price; 

	private String price_sort; 
	private String good_rate_sort;
	private String cur_sort_str; 

	private String search_key;

	private int maxResult = 10;
	private int fistResult = 0; 
	private int pageCurrent = 1; 
	private int maxPage; 

	private int totalResult = 0; 

	private List<Trip> tripList; 

	private List<String> placeList; 
	private List<String> startList; 
	private List<String> themeList; 
	private List<String> trafficList; 
	private List<Integer> timeList; 

	public SearchForm() {
	}

	public SearchForm(String type_name, String place_name, String start_place_name, String theme_name, String traffic,
			Integer time, Integer min_price, Integer max_price, int pageCurrent, String price_sort,
			String good_rate_sort, String cur_sort_str, String search_key) {
		super();
		this.type_name = type_name;
		this.place_name = place_name;
		this.start_place_name = start_place_name;
		this.theme_name = theme_name;
		this.traffic = traffic;
		this.time = time;
		this.min_price = min_price;
		this.max_price = max_price;
		this.pageCurrent = pageCurrent;
		this.price_sort = price_sort;
		this.good_rate_sort = good_rate_sort;
		this.cur_sort_str = cur_sort_str;
		this.search_key = search_key;
		setFistResult(pageCurrent);
	}

	public List<Integer> getPlace_id_list() {
		return place_id_list;
	}

	public void setPlace_id_list(List<Integer> place_id_list) {
		this.place_id_list = place_id_list;
	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	public List<Integer> getTheme_id_list() {
		return theme_id_list;
	}

	public void setTheme_id_list(List<Integer> theme_id_list) {
		this.theme_id_list = theme_id_list;
	}

	public String getTheme_name() {
		return theme_name;
	}

	public void setTheme_name(String theme_name) {
		this.theme_name = theme_name;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getMin_price() {
		return min_price;
	}

	public void setMin_price(Integer min_price) {
		this.min_price = min_price;
	}

	public Integer getMax_price() {
		return max_price;
	}

	public void setMax_price(Integer max_price) {
		this.max_price = max_price;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public List<Integer> getStart_place_id_list() {
		return start_place_id_list;
	}

	public void setStart_place_id_list(List<Integer> start_place_id_list) {
		this.start_place_id_list = start_place_id_list;
	}

	public String getStart_place_name() {
		return start_place_name;
	}

	public void setStart_place_name(String start_place_name) {
		this.start_place_name = start_place_name;
	}

	public String getPrice_sort() {
		return price_sort;
	}

	public void setPrice_sort(String price_sort) {
		this.price_sort = price_sort;
	}

	public String getGood_rate_sort() {
		return good_rate_sort;
	}

	public void setGood_rate_sort(String good_rate_sort) {
		this.good_rate_sort = good_rate_sort;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public int getFistResult() {
		return fistResult;
	}

	public void setFistResult(int pageCurrent) {
		this.fistResult = (pageCurrent - 1) * getMaxResult();
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int totalResult) {
		this.maxPage = totalResult % getMaxResult() == 0 ? totalResult / getMaxResult()
				: totalResult / getMaxResult() + 1;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		setMaxPage(totalResult);
	}

	public List<Trip> getTripList() {
		return tripList;
	}

	public void setTripList(List<Trip> tripList) {
		ArrayList<Trip> new_trips = new ArrayList<Trip>();
		for (Trip t : tripList) {
			Trip trip = new Trip();
			Sequence sequence = new Sequence();
			// ����ҳtrim��������������
			sequence.setValue("  " + t.getSequence().getType());
			trip.setSequence(sequence);

			City start = new City();
			start.setName(t.getCity().getName());
			trip.setCity(start);

			Set<Themeontrip> tot_list = new HashSet();
			Iterator it_theme=t.getThemeontrips().iterator();
			while(it_theme.hasNext()){
				Themeontrip tot=(Themeontrip) it_theme.next();
				Themeontrip new_tot = new Themeontrip();
				Theme th = new Theme();
				th.setName(tot.getTheme().getName());
				new_tot.setTheme(th);
				tot_list.add(new_tot);
			}
			trip.setThemeontrips(tot_list);

			Set<Placeontrip> pot_list = new HashSet();
			Iterator it_place=t.getPlaceontrips().iterator();
			while(it_place.hasNext()){
				Placeontrip pot=(Placeontrip) it_place.next();
				Placeontrip new_pot = new Placeontrip();
				Place p = new Place();
				p.setName(pot.getPlace().getName());
				new_pot.setPlace(p);
				pot_list.add(new_pot);
			}
			trip.setPlaceontrips(pot_list);

			Set<Trippicture> pic_list = new HashSet<>();
			Iterator it_trippic = t.getTrippictures().iterator();
			while(it_trippic.hasNext()){
				Trippicture tp=(Trippicture) it_trippic.next();
				Trippicture new_tp = new Trippicture();
				new_tp.setName(tp.getName());
				new_tp.setData(tp.getData());
				pic_list.add(new_tp);
			}
			trip.setTrippictures(pic_list);

			Set<Price> p_list = new HashSet();
			Iterator it_price=t.getPrices().iterator();
			while(it_price.hasNext()){
				Price p=(Price) it_price.next();
				Price new_p = new Price();
				new_p.setPrice(p.getPrice());
				new_p.setDate(p.getDate());
				p_list.add(new_p);
			}
			trip.setPrices(p_list);

			trip.setId(t.getId());
//			trip.setMain_picname(t.getMain_picname());
//			trip.setMin_price(t.getMin_price());
			trip.setGoodRate(t.getGoodRate());
			trip.setTitle(t.getTitle());
			trip.setTraffic(t.getTraffic());
			trip.setHotel(t.getHotel());
			trip.setTime(t.getTime());
			new_trips.add(trip);
		}
		this.tripList = new_trips;
	}

	public List<String> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<String> placeList) {
		this.placeList = placeList;
	}

	public List<String> getStartList() {
		return startList;
	}

	public void setStartList(List<String> startList) {
		this.startList = startList;
	}

	public List<String> getThemeList() {
		return themeList;
	}

	public void setThemeList(List<String> themeList) {
		this.themeList = themeList;
	}

	public List<String> getTrafficList() {
		return trafficList;
	}

	public void setTrafficList(List<String> trafficList) {
		this.trafficList = trafficList;
	}

	public List<Integer> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Integer> timeList) {
		this.timeList = timeList;
	}

	public String getSearch_key() {
		return search_key;
	}

	public void setSearch_key(String search_key) {
		this.search_key = search_key;
	}

	public String getCur_sort_str() {
		return cur_sort_str;
	}

	public void setCur_sort_str(String cur_sort_str) {
		this.cur_sort_str = cur_sort_str;
	}

}
