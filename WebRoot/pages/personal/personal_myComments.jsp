<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="com.qunawan.entity.*" %>
<%@ page language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="/common/header.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人空间-我的点评</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personalCss.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.Jcrop.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/img_account.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/DB_gallery.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/jquery.Jcrop.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/birthday.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
	<script type="text/javascript" type="text/javascript">
		var jcrop_api, boundx, boundy, $preview, $pcnt, pimg;
		var xsize, ysize;
		$(document).ready(function(e) {
			$preview = $('.img-preview');
			$pcnt = $('.img-preview .img-contbox');
			$pimg = $('.img-preview .img-contbox img');
			xsize = $pcnt.width();
			ysize = $pcnt.height();
		});
	</script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/personal_information.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/personal_comment.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/jquery.DB_gallery.js"></script>
	<!-- 星星等级插件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/jquery.barrating.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/examples.js"></script>
	<!-- 待评论上传图片 -->
	<!-- 引用核心层插件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/zyFile.js"></script>
	<!-- 引用控制层插件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/zyUpload.js"></script>
	<!-- 引用初始化JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/pages/personal/frame/upFile.js"></script>
	<!-- 待评论上传图片 -->
	<base href="<%=basePath%>" />
</head>
<body>
	<!-- 个人空间 开始-->
	<div class="content_infor">
		<a href="index.jhtml">我的去哪玩</a>> <a
			href="personalinfo.jhtml?type=init">个人空间</a>>
		<a id="target_title3" href="javascript:;">我的点评</a><span
			id="comment_info"
			style="width: 200px; font-size: 14px; color: red; margin-left: 200px">${comment_info}</span>
	</div>
	<div class="content_all" style="height:20px;clear:both;">

		<!-- 左边  菜单栏开始-->

		
		<div class="content_left">
	<div class="content_left_first">
		<c:choose>
			<c:when test="${empty user.imgPath }">
				<img src="img/headimg.png" class="img_head" />
			</c:when>
			<c:otherwise>
				<img src="${pageContext.request.contextPath }/user_img/${user.imgPath}"
					class="img_head" />
			</c:otherwise>
		</c:choose>
		<p>编辑我的资料</p>
	</div>
	<div class="content_left_two">
		<ul>
			<li ><a
				href="user!prepareOrder.action"><span
					class="icon  icon_my_re_list "> </span> <span
					class="position_my_re_list">我的约单</span> </a></li>
			<li><a
				href="user!prepareInfo.action"><span
					class="icon  icon_my_re_list  icon_personal"> </span> <span
					class="position_my_re_list">个人信息</span></a></li>
			<li ><a
				href="user!preparePwd.action"><span
					class="icon  icon_my_re_list  icon_password" style=""> </span> <span
					class="position_my_re_list">密码修改</span></a></li>
			<li class="backgroundClass"}><a
				href="user!prepareComment.action"><span
					class="icon  icon_my_re_list icon_comment " style=""> </span> <span
					class="position_my_re_list">我的点评</span></a></li>
			<span class="hr_css">
				<hr style="width: 120px; border-top: 1px #ccc solid;" />
			</span>
			<li><a
				href="${pageContext.request.contextPath }/mycontact.jhtml?type=getContacts"><span
					class="icon  icon_my_re_list iconusually" style=""> </span> <span
					class="position_my_re_list">常用游客信息</span></a></li>
			<li style="cursor:default"><a href="javascript:;" style="cursor:default"><span 
					class="icon  icon_my_re_list icon_card " style="cursor: default;color: gray;"> </span> <span style="cursor:default; color: gray;"
					class="position_my_re_list">礼品卡</span></a></li>
			<li style="cursor: default;text-decoration:none;"><a href="javascript:;" style="cursor:default"><span
					class="icon  icon_my_re_list iconmoney " style="cursor: default;color: gray;"> </span> <span style="cursor: default;color: gray;"
					class="position_my_re_list">我的积分</span></a></li>
			<li style="cursor:default"><a href="javascript:;" style="cursor:default"><span
					class="icon  icon_my_re_list icon_email " style="cursor: default;color: gray;"> </span> <span style="cursor: default;color: gray;"
					class="position_my_re_list">邮件订阅</span></a></li>
			<span class="hr_css">
				<hr style="width: 120px; border-top: 1px #ccc solid;" />
			</span>
			<li style="cursor:default"><a href="javascript:;" style="cursor:default"><span
					class="icon  icon_my_re_list icon_vip" style="cursor: default;color: gray;"> </span> <span style="cursor: default;color: gray;"
					class="position_my_re_list ">会员俱乐部</span></a></li>
			<li style="cursor:default"><a href="javascript:;" style="cursor:default"><span
					class="icon  icon_my_re_list icon_way" style="cursor: default;color: gray;"> </span> <span style="cursor: default;color: gray;"
					class="position_my_re_list">我的攻略</span></a></li>
			<li style="cursor:default"><a href="javascript:;" style="cursor:default"><span
					class="icon  icon_my_re_list icon_collection" style="cursor: default;color: gray;"> </span> <span style="cursor: default;color: gray;"
					class="position_my_re_list" style="cursor:default">我的收藏</span></a></li>
			<li style="cursor:default"><a href="javascript:;" style="cursor:default"><span
					class="icon  icon_my_re_list icon_my_tour" style="cursor: default;color: gray;"> </span> <span style="cursor: default;color: gray;"
					class="position_my_re_list">我的游记</span></a></li>
		</ul>
	</div>
</div>
		
		<!-- 左边  菜单栏结事-->


		<!-- 右侧  选项卡开始-->
		<div class="content_right_pa">

			<!-- 右侧     我的点评 开始-->
			<div class="content_right bordernone" id="my_comment_content">
				<span class="changePassWord">我的点评</span>
				<hr class="hr_css_red" />
				<div class="content_detail">
					<div class="head_detail">
						<ul>
							<li id="to_comment">待点评</li>
							<li id="comments">已点评</li>
						</ul>
						<span class="float_right">您曾经购买产品的点评……</span>
					</div>
					<div class="to_comment_detail">
<!-- 						<div class="feature_spoc" id="wait_comments">
							<div id="loading"></div>
						</div> -->
						<div class="comstati clearfix">
						<%int i=0; %>
						<c:forEach items="${myComment}" var="c" end="2">
							<div class="com-null">
								<span class="com_count_img"> 
									<%
										List<Comment> cl=(List<Comment>)session.getAttribute("myComment");
										Comment cc=cl.get(i);
										String pic=cc.getTrip().getTrippictures().iterator().next().getName();
										i++;
									 %>
									<img src="${pageContext.request.contextPath}/image_cache/<%=pic%>" />
								</span>
							<div class="com_count_detail">
								<p>
									<em>订单号：</em> 
									<strong>${c.orders.orderNo}</strong>
								</p>
								<p>
									<em>好&nbsp;评：</em> 
									<strong>${c.trip.goodRate}%</strong>
								</p>
								<p>
									<em>产品名称：</em> 
									<em>${c.trip.STitle}</em>
								</p>
								<p>
									<em>出行时间：</em> 
									<em>${c.trip.time}</em>
								</p>
							</div>
							<div class="dp_write">
								<a class="icon_writeBtn" id="'+ value.orderid+ '" href="javascript:;" data-placeid="79" data-orderid="" data-productid=""></a>
								<p>
									<strong>${c.usefull}</strong> 位驴友点评过
								</p>
							</div>
							</div>
							<div class="js_content" sytle="height:50px;clear:both">
							</div>
						</div>
					</c:forEach>
					</div>
					<div class="comments_detail" id="finish_comments"></div>

				</div>
			</div>

		</div>
		<!-- 右侧    我的点评 结束 -->
	</div>
	<!-- 右边  选项卡结束-->
	<!-- 个人空间 结束-->

	<!-- 引入尾部开始 -->
	<iframe src="common/footer.jsp"
		style="width: 100%; height: 650px; border: 0; overflow: hidden;"></iframe>
	<!-- 引入尾部结束 -->
	<!--  显示评论上传的图片 开始-->
	<script type="text/javascript">
    $('.DB_gallery').DB_gallery({
        thumWidth: 86,
        thumGap: 8,
        thumMoveStep: 4,
        moveSpeed: 300,
        fadeSpeed: 500
    });
</script>
</body>
</html>