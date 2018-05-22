<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page language="java" import="com.qunawan.entity.*"%>
<%@page language="java" import="com.qunawan.globle.*"%>
<%@page language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<%
	List<Trip> trips = (List<Trip>) session.getAttribute("trips");
	Integer count = (Integer) session.getAttribute("count");
	String key = (String) session.getAttribute("key");
	Integer pageCurrent = (Integer) session.getAttribute("page");
	Integer pageTotal = (int)Math.ceil(count/10.0);
%>
<title>${key}旅游报价_路线推荐-去哪玩</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/pages/trip/search.js"></script>
<base href="<%=basePath%>" />
</head>
<body>
	<!-- header【开始】 -->
	<%@ include file="/common/header.jsp"%>
	<!-- header【结束】 -->
	<!-- 主体【开始】 -->
	<div class="body_bg">
		<div class="base">
			<!-- 导航栏【开始】 -->
			<div class="navigation">
				<span class="font_g9"> 您当前所在的位置： <a href="index">首页</a> > <a
					href="trip!searchTrip.action">所有路线</a> > <a href="trip!searchTrip.action?key=${key}">${key}</a>
				</span>
			</div>

			<!-- 导航栏【结束】 -->

			<!-- 筛选框【开始】 -->
			<div class="filter_box">
				<div class="head">
					<ul>
						<li class="all cur"><a href="trip!searchTrip.action?key=${key}">全部</a></li>
						<li class="other"><a href="trip!searchTrip.action?key=${key}&triptype=自驾游">自驾游（10）</a></li>
						<li class="other"><a href="trip!searchTrip.action?key=${key}&triptype=国内游">国内游（5）</a></li>
						<li class="other"><a href="trip!searchTrip.action?key=${key}&triptype=出境游">出境游（2）</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="body">
					<div class="area option">
						<div class="title">地区</div>
						<dl class="ddlist">
							<dt>
								<span><a class="cur" href="trip!searchTrip.action?key=${key}">全部</a></span>
							</dt>
							<dd>
							<%
								String str="trip!searchTrip.action?key=${key}&start_place=";
							 %>
								<span><a href="<%=str%>普吉岛">普吉岛 (131)</a></span> <span><a href="<%=str%>泰国">泰国
										(26)</a></span> <span><a href="<%=str%>曼谷">曼谷 (131)</a></span> <span><a
									href="<%=str%>芭提雅">芭提雅 (26)</a></span> <span><a href="<%=str%>甲米">甲米 (131)</a></span> <span><a
									href="<%=str%>普吉">普吉 (26)</a></span> <span><a href="<%=str%>亚洲">亚洲 (131)</a></span> <span><a
									href="<%=str%>普吉">清迈 (26)</a></span> <span><a href="<%=str%>香港">香港 (131)</a></span> <span><a
									href="<%=str%>岘港">岘港 (26)</a></span> <span><a href="<%=str%>斯米兰">斯米兰 (131)</a></span> <span><a
									href="<%=str%>岘港">印度 (26)</a></span> <span><a href="<%=str%>新德里">新德里 (131)</a></span> <span><a
									href="<%=str%>马六甲">马六甲 (26)</a></span> <span><a href="<%=str%>吉隆坡">吉隆坡 (131)</a></span> <span><a
									href="<%=str%>马来西亚">马来西亚 (26)</a></span> <span><a href="<%=str%>新加坡">新加坡 (131)</a></span> <span><a
									href="<%=str%>清莱">清莱 (26)</a></span> <span><a href="<%=str%>普吉岛">普吉岛 (131)</a></span> <span><a
									href="<%=str%>泰国">泰国 (26)</a></span> <span><a href="<%=str%>曼谷 ">曼谷 (131)</a></span> <span><a
									href="<%=str%>芭提雅">芭提雅 (26)</a></span> <span><a href="<%=str%>甲米">甲米 (131)</a></span> <span><a
									href="<%=str%>普吉">普吉 (26)</a></span> <span><a href="<%=str%>亚洲">亚洲 (131)</a></span> <span><a
									href="<%=str%>清迈">清迈 (26)</a></span> <span><a href="<%=str%>香港">香港 (131)</a></span> <span><a
									href="<%=str%>岘港">岘港 (26)</a></span> <span><a href="<%=str%>斯米兰">斯米兰 (131)</a></span> <span><a
									href="<%=str%>印度">印度 (26)</a></span> <span><a href="<%=str%>新德里">新德里 (131)</a></span> <span><a
									href="<%=str%>马六甲">马六甲 (26)</a></span> <span><a href="<%=str%>吉隆坡">吉隆坡 (131)</a></span> <span><a
									href="<%=str%>马来西亚">马来西亚 (26)</a></span> <span><a href="<%=str%>新加坡">新加坡 (131)</a></span> <span><a
									href="<%=str%>清莱">清莱 (26)</a></span>
							</dd>
						</dl>
						<a href="javascript:void(0);" class="more more_y">更多<i class="arrow_down"></i></a>
						<div class="clear"></div>
					</div>
					<div class="setout option topborder">
						<div class="title">出发地</div>
						<dl class="ddlist">
							<dt>
								<span><a class="cur" href="trip!searchTrip.action?key=${key}">全部</a></span>
							</dt>
							<dd>
								<span><a href="trip!searchTrip.action?key=${key}&place=成都">成都 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=北京">北京
										(26)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=上海">上海 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=无锡 ">无锡 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=杭州">杭州 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=南京">南京 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=普吉">普吉 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}">不限出发地 (26)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=宁波">宁波 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=深圳">深圳 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=广州">广州 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=重庆">重庆 (26)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=长沙">长沙 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=青岛">青岛 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=天津">天津 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=温州">温州 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=清莱">清莱 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=成都">成都 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=北京 ">北京 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=上海">上海 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=无锡 ">无锡 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=杭州 ">杭州 (26)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=无锡 ">南京 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=普吉 ">普吉 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}">不限出发地 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=宁波">宁波 (26)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=深圳">深圳 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=广州">广州 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=重庆">重庆 (26)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=长沙">长沙 (131)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=青岛 ">青岛 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=天津">天津 (26)</a></span> <span><a href="trip!searchTrip.action?key=${key}&place=温州 ">温州 (131)</a></span> <span><a
									href="trip!searchTrip.action?key=${key}&place=天津">清莱 (26)</a></span>
							</dd>
						</dl>
						<a href="javascript:void(0);" class="more more_y">更多<i class="arrow_down"></i></a>
						<div class="clear"></div>
					</div>
					<div class="theme option topborder">
						<div class="title">主题</div>
						<dl class="ddlist">
							<dt>
								<span><a class="cur" href="trip!searchTrip.action?key=${key}">全部</a></span>
							</dt>
							<%String str1="trip!searchTrip.action?key=${key}&theme=";%>
							<dd>
								<span><a href="<%=str1%>海滨岛屿">海滨岛屿 (131)</a></span> <span><a href="<%=str1%>亲子">亲子
										(26)</a></span> <span><a href="<%=str1%>民俗文化 ">民俗文化 (131)</a></span> <span><a
									href="<%=str1%>都市观光">都市观光(131)</a></span> <span><a href="<%=str1%>潜水 ">潜水 (26)</a></span> <span><a
									href="<%=str1%>游船">游船 (131)</a></span> <span><a href="<%=str1%>山水景观">山水景观 (131)</a></span> <span><a
									href="<%=str1%>宗教">宗教 (26)</a></span> <span><a href="<%=str1%>演艺 ">演艺 (26)</a></span> <span><a
									href="<%=str1%>美食">美食 (131)</a></span> <span><a href="<%=str1%>夜景 ">夜景 (131)</a></span> <span><a
									href="<%=str1%>当地跟团">当地跟团 (26)</a></span> <span><a href="<%=str1%>当地玩乐娱乐">当地玩乐娱乐
										(131)</a></span> <span><a href="<%=str1%>摄影">摄影 (131)</a></span> <span><a
									href="<%=str1%>田园度假 ">田园度假 (26)</a></span> <span><a href="<%=str1%>动植物园">动植物园 (131)</a></span>
								<span><a href="<%=str1%>海滨岛屿">海滨岛屿 (131)</a></span> <span><a href="<%=str1%>亲子">亲子
										(26)</a></span> <span><a href="<%=str1%>民俗文化">民俗文化 (131)</a></span> <span><a
									href="<%=str1%>都市观光 ">都市观光 (131)</a></span> <span><a href="<%=str1%>潜水">潜水 (26)</a></span> <span><a
									href="<%=str1%>游船">游船 (131)</a></span> <span><a href="<%=str1%>山水景观">山水景观 (131)</a></span> <span><a
									href="<%=str1%>宗教">宗教 (26)</a></span> <span><a href="<%=str1%>演艺 ">演艺 (26)</a></span> <span><a
									href="<%=str1%>美食">美食 (131)</a></span> <span><a href="<%=str1%>夜景">夜景(131)</a></span> <span><a
									href="<%=str1%>当地跟团">当地跟团 (26)</a></span> <span><a href="<%=str1%>当地玩乐娱乐">当地玩乐娱乐
										(131)</a></span> <span><a href="<%=str1%>摄影">摄影 (131)</a></span> <span><a
									href="<%=str1%>田园度假">田园度假 (26)</a></span> <span><a href="<%=str1%>动植物园">动植物园 (131)</a></span>
							</dd>
						</dl>
						<a href="javascript:void(0);" class="more more_y">更多<i class="arrow_down"></i></a>
						<div class="clear"></div>
					</div>
					<div class="traffic option topborder">
						<div class="title">交通工具</div>
						<dl class="ddlist">
							<dt>
								<span><a class="cur" href="trip!searchTrip.action?key=${key}">全部</a></span>
							</dt>
							<%String str2="trip!searchTrip.action?key=${key}&traffic=";%>
							<dd>
								<span><a href="<%=str2%>飞机">飞机(131)</a></span> <span><a href="<%=str2%>火车">火车
										(26)</a></span> <span><a href="<%=str2%>游轮 ">游轮 (131)</a></span>
							</dd>
						</dl>
						<a href="javascript:void(0);" class="more more_y">更多<i class="arrow_down"></i></a>
						<div class="clear"></div>
					</div>
					<div class="days option topborder">
						<div class="title">出行天数</div>
						<dl class="ddlist">
							<dt>
								<span><a class="cur" href="trip!searchTrip.action?key=${key}">全部</a></span>
							</dt>
							<%String str3="trip!searchTrip.action?key=${key}&time=";%>
							<dd>
								<span><a href="<%=str3%>1天 ">1(131)</a></span> <span><a href="<%=str3%>2天">2
										(26)</a></span> <span><a href="<%=str3%>3">3天 (131)</a></span> <span><a
									href="<%=str3%>4">4天 (26)</a></span> <span><a href="<%=str3%>5">5天 (131)</a></span> <span><a
									href="<%=str3%>6">6天 (26)</a></span> <span><a href="<%=str3%>7">7天 (131)</a></span> <span><a
									href="<%=str3%>"14>14天 (26)</a></span> <span><a href="<%=str3%>15">15天 (131)</a></span> <span><a
									href="<%=str3%>21">21天 (26)</a></span>
							</dd>
						</dl>
						<a href="javascript:void(0);" class="more more_y">更多<i class="arrow_down"></i></a>
						<div class="clear"></div>
					</div>
					<div class="border option topborder">
						<div class="title">是否出境</div>
						<dl class="ddlist">
							<dt>
								<span><a class="cur" href="trip!searchTrip.action?key=${key}">全部</a></span>
							</dt>
							<%String str4="trip!searchTrip.action?key=${key}&triptype=";%>
							<dd>
								<span><a href="<%=str4%>国内游">国内 (131)</a></span> <span><a href="<%=str4%>出境游">出境
										(26)</a></span>
							</dd>
						</dl>
						<a href="javascript:void(0);" class="more more_y">更多<i class="arrow_down"></i></a>
						<div class="clear"></div>
					</div>
				</div>
				<div class="tail">
					<p class="result">
						<b>${count}</b>条结果
					</p>
					<dl class="request_list">
						<dt>您已选择：</dt>
						<dd>
							<a class="close_all" href="trip!searchTrip.action?key=${key}">清除所有条件</a>
						</dd>
					</dl>
					<a class="condition condition_up" href="javascript:void(0);"> 收起筛选条件 <i
						class="arrow_up"></i>
					</a> <a class="condition condition_down" href="javascript:void(0);"> 更多筛选条件 <i
						class="arrow_down"></i>
					</a>
					<div class="clear"></div>
				</div>
			</div>
			<!-- 筛选框【结束】 -->

			<!-- 主体内容【开始】 -->
			<div class="top10">
				<!-- 右侧内容【开始】 -->
				<div class="main_r">
					<!-- 服务保障【开始】 -->
					<div class="common_box box">
						<h4 class="common_title">服务保障</h4>
						<ul>
							<li><i class="icon1"></i>
								<p>
									<b>价格保障</b><span>同类产品，保证低价</span>
								</p></li>
							<li><i class="icon2"></i>
								<p>
									<b>退订保障</b><span>因特殊情况影响出行，保证退订</span>
								</p></li>
							<li><i class="icon2"></i>
								<p>
									<b>退订保障</b><span>因特殊情况影响出行，保证退订</span>
								</p></li>
							<li><i class="icon3"></i>
								<p>
									<b>救援保障</b><span>旅途中遇以外情况，保证救援</span>
								</p></li>
							<li><i class="icon4"></i>
								<p>
									<b>7×24小时服务</b><span>快速响应，全年无休</span>
								</p></li>
						</ul>
					</div>
					<!-- 服务保障【结束】 -->

					<!-- 当地旅游首页【开始】 -->
					<div class="local_index box">
						<h4>千岛湖首页</h4>
						<p>
							千岛湖因湖内拥有星罗棋布的1078个岛屿而得名。它也是世界上岛屿最多的湖。景区群山绵延，森林繁茂，湖水晶莹透澈，被赞誉为“天下第一秀水”。而那句家喻户晓的“农夫山泉，有点甜”，它的水就取自于千岛湖。...
							<a href="trip!showDetail.action?id=12&type=国内游">更多</a>
						</p>
						<ul>
							<li><a href="trip!showDetail.action?id=12&type=国内游">概况</a></li>
							<li><a href="trip!showDetail.action?id=12&type=国内游">指南</a></li>
							<li><a href="trip!showDetail.action?id=12&type=国内游">景点</a></li>
							<li><a href="trip!showDetail.action?id=12&type=国内游">住宿</a></li>
							<li><a href="trip!showDetail.action?id=12&type=国内游">娱乐</a></li>
							<li><a href="trip!showDetail.action?id=12&type=国内游">交通</a></li>
							<li><a href="trip!showDetail.action?id=12&type=国内游">游记</a></li>
						</ul>
					</div>
					<!-- 当地旅游首页【结束】 -->

					<!-- 当地旅游评价【开始】 -->
					<div class="local_comment box">
						<h4 class="common_title">千岛湖点评</h4>
						<div class="score">
							<div class="score_l">
								<span class="score1"><b>4.08</b>分</span> <span class="score2"><i
									style="width: 30%"></i></span>
								<p class="comments">
									<a href="trip!showDetail.action?id=12&type=国内游"> 916条评论 </a>
								</p>
							</div>
							<ul class="score_r">
								<li>人气<span><i>4.02</i>分</span></li>
								<li>规模<span><i>3.91</i>分</span></li>
								<li>观光<span><i>3.93</i>分</span></li>
								<li>服务<span><i>3.93</i>分</span></li>
							</ul>
						</div>
					</div>
					<!-- 当地旅游评价【结束】 -->
				</div>
				<!-- 右侧内容【结束】 -->

				<!-- 左侧列表【开始】 -->
				<div class="main_l">
					<!-- 排序筛选【开始】 -->
					<div class="sort">
						<ul>
							<li class="active"><a href="javascript:void(0);">去哪玩推荐</a></li>
							<li class="price" title="按价格由低到高排序"><a href="javascript:void(0);">价格 </a><i
								class="sort_up"></i></li>
							<li class="comment" title="按好评率由高到低排序"><a href="javascript:void(0);">好评率 </a><i
								class="sort_down"></i></li>
							<li>
								<div>
									<input type="text" class="txt" id="price1" value=""
										onkeydown="validNum();" /> <b>-</b> <input type="text"
										class="txt" id="price2" value="" onkeydown="validNum();" /> <a
										class="submit" href="javascript:void(0);">确定</a>
								</div>
							</li>
						</ul>
						<div class="page">
							<p class="count_num">
								<b><%=pageCurrent%></b>/<%=pageTotal%>
							</p>
							<a class="prev"
								href="trip!searchTrip.action?page=${pageCurrent-1}&key=${key}"><i
								class="arrow_p"></i></a> <a class="next"
								href="trip!searchTrip.action?page=${pageCurrent+1}&key=${key}"><i
								class="arrow_n"></i></a>
						</div>
					</div>
					<!-- 排序筛选【结束】 -->

					<!-- 产品列表【开始】 -->

					<!-- 第一个搜索记录【start】 -->
					<%int i=0; %>
					<c:forEach items="${t_list}" var="trip">
						<div class="recommend">
							<div class="detail">
								
								<%
									List<Trip> list=(List<Trip>)session.getAttribute("t_list");
									String pic=list.get(i).getTrippictures().iterator().next().getName();
									Iterator it=list.get(i).getPrices().iterator();
									Float p1=((Price)it.next()).getPrice();
									while(it.hasNext()){
										Float f=((Price)it.next()).getPrice();
										if(f<p1)
											p1=f;
									}
								 %>
							
								<a class="detail_img" href="trip!showDetail.action?id=${trip.id}&type=${trip.sequence.value}" target="_blank"> <img
									src="image_cache/<%=pic%>" width="195" height="130"><span
										class="detail_tag detail_tag_blue">${trip.sequence.value}</span></a>
								<div class="price">
									<p class="priceTitle">去哪玩价:</p>
									<p class="priceBox">
										<span> ¥ <b><%=p1%></b>
										</span> <label name="origLable">起/人</label>
									</p>
									<p class="good_comment">
										<span>${trip.goodRate}%</span>好评率
									</p>
								</div>
								<div class="detail">
									<div class="detail_list">
										<p class="detail_title">
											<span class="title_left">${trip.city.name}出发 |</span> <a
												href="trip!showDetail.action?id=${trip.id}&type=${trip.sequence.value}" target="_blank">${trip.title}
											</a>
										</p>
										<dl class="detail_text theme_text">
											<dt>主&nbsp;题</dt>
											<dd>
												<p>
													<c:forEach items="${trip.themeontrips}" var="tot">
													${tot.theme.name},
												</c:forEach>
												</p>
											</dd>
										</dl>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="discribe">
								<ul>
									<li>
										<p>
											<span class="icon icon_traffic"></span>交通
										</p>
										<p>
											<span>${trip.traffic}</span> <span><a href="#"></a></span>
										</p>
									</li>
									<li class="js_tips" tip-content="">
										<p>
											<span class="icon icon_stay"></span>住宿
										</p>
										<p>
											<span>${trip.hotel}</span> <span><a href="#"></a></span>
										</p>
									</li>
									<li class="js_tips" tip-content="">
										<p>
											<span class="icon icon_time"></span>行程天数
										</p>
										<p>
											<span>${trip.time}天</span> <span><a
												href="../tourist_detail/tourist_detail.html" class="more">更多</a></span>
										</p>
									</li>
									<li class="js_tips" tip-content="">
										<p>
											<span class="icon icon_date"></span>出发日期
										</p>
										<p>
											<span>10-01</span> <span><a
												href="../tourist_detail/tourist_detail.html" class="more">更多</a></span>
										</p>
									</li>
								</ul>
								<div class="clear"></div>
							</div>
							<div class="tip"></div>
							<div class="clear"></div>
						</div>
						<%i++; %>
					</c:forEach>
					<!-- 第一个搜索记录【end】 -->

					<!-- 产品列表【结束】 -->
				</div>
				<!-- 左侧列表【结束】 -->
				<div class="clear"></div>
			</div>
			<!-- 主体内容【结束】 -->
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/search.js"></script>
	<!-- 主体【结束】 -->

	<!-- footer【开始】 -->
	<div class="public_ft_box">
		<div class="wrap">
			<a class="public_ft" href="#" target="_blank">
				<ul class="public_ft_list">
					<li><i class="ft_ioc1"></i><strong>价格保证</strong>同类产品，保证低价</li>
					<li><i class="ft_ioc2"></i><strong>退订保障</strong>因特殊情况影响出行，保证退订</li>
					<li><i class="ft_ioc3"></i><strong>救援保障</strong>旅途中遇意外情况，保证援助</li>
					<li><i class="ft_ioc4"></i><strong>7x24小时服务</strong>快速响应，全年无休</li>
				</ul>
			</a>
		</div>
	</div>
	<div class="footer_fuwu_box">
		<div class="footer_fuwu">
			<dl>
				<dt>关于我们</dt>
				<dd>
					<a href="#" target="_blank" title="简介">去哪玩简介</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="旅游度假资质">旅游度假资质</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="用户体验平台">用户体验平台</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="网站地图">网站地图</a>
				</dd>
			</dl>
			<dl>
				<dt>联系我们</dt>
				<dd>
					<a href="#" target="_blank" title="门店信息">门店信息</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="意见反馈">意见反馈</a>
				</dd>
				<dd>
					<i class="lv_icon icon_wb"></i><a href="#" target="_blank"
						title="微博">微博</a>
				</dd>
				<dd>24小时服务电话</dd>
				<dd>
					<span class="fot_call">021-123456</span>
				</dd>
				<dd>免长话费，全年无休</dd>
			</dl>
			<dl>
				<dt>订购指南</dt>
				<dd>
					<a href="#" target="_blank" title="门票使用">门票使用</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="常见问题">常见问题</a>
				</dd>
			</dl>
			<dl>
				<dt>支付方式</dt>
				<dd>
					<a href="#" target="_blank" title="账户支付">账户支付</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="礼品卡支付">礼品卡支付</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="电话预授权支付">电话预授权支付</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="分期付款">分期付款</a>
				</dd>
			</dl>
			<dl>
				<dt>特色服务</dt>
				<dd>
					<a href="#" target="_blank" title="团购预约">团购预约</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="分销系统">分销系统</a>
				</dd>
			</dl>
			<dl>
				<dt>售后服务</dt>
				<dd>
					<a href="#" target="_blank" title="退换货说明">退换货说明</a>
				</dd>
				<dd>
					<a href="#" target="_blank" title="投诉建议">投诉建议</a>
				</dd>
			</dl>
			<div class="footer_dy">
				<h4>订阅特价、促销信息</h4>

				<div class="footer_email y_s_one">
					<input class="y_input" type="text" value="输入Email(如：a@b.c)"
						onfocus="if(value=='输入Email(如：a@b.c)'){value=''}"
						onblur="if (value ==''){value='输入Email(如：a@b.c)'}"><a
						class="yjdy_btn" href="javascript:;">订阅</a><i
						class="lv_icon icon_xx"></i>
				</div>
				<div class="y_error_msg">
					<i class="y_jiao"></i>
				</div>

				<div class="footer_ewm">
					<i class="lv_icon icon_ewm"></i>
				</div>
			</div>
		</div>
	</div>
	<div class="end">
		<div class="end_base">

			<div class="info">
				<p>上海去哪玩国际旅行社有限公司。旅行社业务经营许可证编号：L-SH-CJ12345</p>
				<p>Copyright © 2015 www.qunawan.com. 上海尚强信息科技有限公司版权所有
					沪ICP备12345678号-1 增值电信业务经营许可证编号：沪B1-20151028</p>
			</div>

			<ul class="ico pointer">
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li class="i"></li>
				<li>上海市旅游行业协会在线分会</li>
				<li>网站备案</li>
				<li>网络110</li>
				<li>支付宝特约商家</li>
				<li>AAA级信用企业</li>
				<li>上海工商</li>
				<li>可信网站</li>
				<li>诚信认证</li>
				<li>网络社会征信网</li>
				<li>360网站安全检测</li>
				<li>网监安全</li>
				<li>文明旅游</li>
				<div class="clear"></div>
			</ul>

			<div class="top50"></div>
			<ul class="text">
				<li class="title">热门精选：</li>

				<li><a>厦门旅游攻略</a></li>
				<li><a>香港旅游攻略</a></li>
				<li><a>黄山</a></li>
				<li><a>泰国旅游</a></li>
				<li><a>杭州旅游攻略</a></li>

				<li><a>珠海长隆海洋王国</a></li>
				<li><a>西安旅游攻略</a></li>
				<li><a>横店影视城</a></li>
				<li><a>鼓浪屿</a></li>

				<li class="more"><a>更多</a></li>
				<div class="clear"></div>
			</ul>

			<ul class="text">
				<li class="title">集团网站：</li>

				<li><a>景域集团</a></li>
				<li><a>奇创旅游规划</a></li>
				<li><a>景域旅游营销</a></li>
				<li><a>景域旅发</a></li>
				<li><a>飞驴湾</a></li>

				<li><a>帐篷客</a></li>
				<div class="clear"></div>
			</ul>

			<ul class="text">
				<li class="title">友情链接：</li>

				<li><a>趣驴族旅游网</a></li>
				<li><a>百度旅游</a></li>
				<li><a>人民网旅游</a></li>
				<li><a>央视网旅游</a></li>
				<li><a>中国经济网旅游</a></li>

				<li><a>中华网旅游</a></li>
				<li><a>奇艺旅游</a></li>
				<li><a>凤凰网旅游</a></li>
				<li><a>艺龙旅游</a></li>

				<li class="more"><a>更多</a></li>
				<div class="clear"></div>
			</ul>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/trip/search.js"></script>
	<!-- 主体【结束】 -->

	<!-- 引入尾部开始 -->
	<%@ include file="/common/footer.jsp"%>
	<script type="text/javascript">
		var x = -200;
		var y = -50;
		var row = 0;
		var col = 0;
		$(".end_base ul.ico li.i").each(function(e) {
			row = parseInt(e / 4);
			col = e % 4;
			var p_x = -200;
			var p_y = -50;
			p_x = p_x - 100 * col;
			p_y = p_y - 39 * row;
			var position = p_x + "px " + p_y + "px";
			$(this).css("background-position", position);
		})

		// 智能判断是否可以翻页的功能
		var tmp = $(".count_num").html();
		tmp = tmp.replace("<b>", "");
		tmp = tmp.replace("</b>", "");
		var array = tmp.split("/");
		var current_page = array[0];
		var total_page = array[1];

		if (current_page == 1) {
			$(".prev").addClass("page_no");
			$(".prev").attr("href", "javascript:void(0);");
		}
		if (current_page == total_page) {
			$(".next").addClass("page_no");
			$(".next").attr("href", "javascript:void(0);");
		}
	</script>
	<!-- footer【结束】 -->
</body>
</html>