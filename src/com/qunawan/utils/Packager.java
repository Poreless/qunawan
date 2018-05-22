package com.qunawan.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qunawan.entity.City;
import com.qunawan.entity.Comment;
import com.qunawan.entity.Commentpicture;
import com.qunawan.entity.Contact;
import com.qunawan.entity.Dates;
import com.qunawan.entity.Detail;
import com.qunawan.entity.Ordercontact;
import com.qunawan.entity.Orders;
import com.qunawan.entity.Position;
import com.qunawan.entity.Price;
import com.qunawan.entity.Sequence;
import com.qunawan.entity.Traffic;
import com.qunawan.entity.Trip;
import com.qunawan.entity.Trippicture;
import com.qunawan.entity.User;

public class Packager {

//	public static Sequence packSequence(ResultSet rs) throws SQLException{
//		Sequence seq = new Sequence();
//		seq.setId(rs.getInt("id"));
//		seq.setValue(rs.getString("value"));
//		seq.setKeying(rs.getString("keying"));
//		seq.setType(rs.getString("type"));
//		seq.setDescing(rs.getString("descing"));
//		return seq;
//	}
//	
//	/**
//	 * 封装Contact的普通属性，不包含User
//	 */
//	public static Contact packContact(ResultSet rs) throws SQLException{
//		Contact contact = new Contact();
//		contact.setId(rs.getInt("id"));
//		contact.setBirthday(rs.getDate("birthday"));
//		contact.setCardno(rs.getString("cardno"));
//		contact.setEmail(rs.getString("email"));
//		contact.setName(rs.getString("name"));
//		contact.setPhone(rs.getString("phone"));
//		contact.setSex(rs.getBoolean("sex"));
//		return contact;
//	}
//
//	/**
//	 * 封装OrderContact的普通属性，以及Contact属性，不包含Orders属性
//	 */
//	public static Ordercontact packOrderContact(ResultSet rs) throws SQLException {
//		Ordercontact orderContact = new Ordercontact();
//		orderContact.setId(rs.getInt("id"));
//		orderContact.setContact(packContact(rs));
//		orderContact.setType(rs.getInt("type"));
//		return orderContact;
//	}
//	
//	/**
//	 * 封装User的普通属性，不包含City属性
//	 */
//	public static User packUser(ResultSet rs) throws SQLException {
//		User user = new User();
//		user.setId(rs.getInt("id"));
//		user.setPassword(rs.getString("password"));
//		user.setPhone(rs.getString("phone"));
//		user.setName(rs.getString("name"));
//		user.setSex(rs.getBoolean("sex"));
//		user.setImg_path(rs.getString("img_path"));
//		user.setEmail(rs.getString("email"));
//		user.setReal_name(rs.getString("real_name"));
//		user.setBirthday(rs.getDate("birthday"));
//		return user;
//	}
//
//	/**
//	 * 为行程详情评论进行属性封装
//	 */
//	public static Comment packComment(ResultSet rs) throws SQLException {
//		Comment comment = new Comment();
//		comment.setContent(rs.getString("content"));
//		comment.setHotel(rs.getInt("hotel"));
//		comment.setId(rs.getInt("id"));
//		comment.setPlace(rs.getInt("place"));
//		comment.setService(rs.getInt("service"));
//		comment.setTime(rs.getTimestamp("time"));
//		comment.setTraffic(rs.getInt("traffic"));
//		comment.setUsefull(rs.getInt("usefull"));
//		comment.setUseless(rs.getInt("useless"));
//		return comment;
//	}
//	
//	/**
//	 * 配合packComment为行程详情评论中的图片属性进行封装
//	 * 属性中包含二进制数据
//	 */
//	public static CommentPicture packCommentPicture(ResultSet rs) throws SQLException {
//		CommentPicture cp = new CommentPicture();
//		cp.setId(rs.getInt("id"));
//		cp.setName(rs.getString("name"));
//		cp.setData(rs.getBytes("data"));
//		return cp;
//	}
	
	public static Trippicture packTripPicture(Trippicture tp) throws SQLException {
		Trippicture tpp = new Trippicture();
		tpp.setData(tp.getData());
		tpp.setName(tp.getName());
		tpp.setType(tp.getType());
		return tp;
	}

//	public static Orders packOrder(ResultSet rs) throws SQLException {
//		Orders order = new Orders();
//		order.setId(rs.getInt("id"));
//		order.setCreate_time(rs.getTimestamp("create_time").toString());
//		order.setOrderNo(rs.getString("orderNo"));
//		order.setNum(rs.getInt("num"));
//		order.setTotal_price(rs.getFloat("total_price"));
//		order.setStart_time(rs.getDate("start_time"));
//		order.setGo_point(rs.getString("go_point"));
//		order.setGo_time(rs.getString("go_time"));
//		return order;
//	}
//	
//	public static City packCity(ResultSet rs) throws SQLException {
//		City city = new City();
//		city.setId(rs.getInt("id"));
//		city.setName(rs.getString("name"));
//		city.setType(rs.getInt("type"));
//		return city;
//	}
//	
	public static Price packPrice(ResultSet rs) throws SQLException {
		Price price = new Price();
		price.setPrice(rs.getFloat("price"));
		price.setDate(rs.getDate("date"));
		return price;
	}

//	public static Trip packTrip(ResultSet rs) throws SQLException {
//		Trip trip = new Trip();
//		trip.setId(rs.getInt("id"));
//		trip.setNum(rs.getInt("num"));
//		trip.setTitle(rs.getString("title"));
//		trip.setS_title(rs.getString("s_title"));
//		trip.setTime(rs.getInt("time"));
//		trip.setTraffic(rs.getString("traffic"));
//		trip.setHotel(rs.getString("hotel"));
//		trip.setGood_rate(rs.getFloat("good_rate"));
//		trip.setPlace_score(rs.getFloat("place_score"));
//		trip.setHotel_score(rs.getFloat("hotel_score"));
//		trip.setService_score(rs.getFloat("service_score"));
//		trip.setTraffic_score(rs.getFloat("traffic_score"));
//		return trip;
//	}
//
//	public static Dates packDate(ResultSet rs) throws SQLException {
//		Dates d = new Dates();
//		d.setTitle(rs.getString("title"));
//		d.setNum(rs.getInt("num"));
//		d.setDetail(rs.getString("detail"));
//		d.setHotel(rs.getString("hotel"));
//		d.setMeal(rs.getString("meal"));
//		d.setTraffic(rs.getString("traffic"));
//		return d;
//	}
//
//	public static Position packPosition(ResultSet rs) throws SQLException {
//		Position p = new Position();
//		p.setLevel(rs.getInt("level"));
//		p.setP1(rs.getFloat("p1"));
//		p.setP2(rs.getFloat("p2"));
//		return p;
//	}
//	
//	public static Detail packDetail(ResultSet rs) throws SQLException {
//		Detail d = new Detail();
//		d.setFood(rs.getString("food"));
//		d.setHotel(rs.getString("hotel"));
//		d.setPlace(rs.getString("place"));
//		return d;
//	}
//
//	public static Traffic packTraffic(ResultSet rs) throws SQLException {
//		Traffic tr = new Traffic();
//		tr.setGo_point(rs.getString("go_point"));
//		tr.setGo_time(rs.getString("go_time"));
//		tr.setReturn_point(rs.getString("return_point"));
//		tr.setReturn_time(rs.getString("return_time"));
//		return tr;
//	}
}
