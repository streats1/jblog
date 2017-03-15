<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="header">
			<h1>${title}</h1>       
			<ul>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">블로그 관리</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4> 게시판!!!!!!!!! </h4>
					<p>${view.title} ${vo1.title}</p> 
					<p> ${view.content} ${vo1.content}</p> 
				</div>
				<ul class="blog-list">
				<c:forEach var="vo" items= "${categoryList}" varStatus="status" >
					<li><a href="${pageContext.request.contextPath}/${authUser.id}?no=${vo.no}&PostNo=${vo.postNo}">${vo.title}</a><span>${vo.regDate}</span>	
					</li> 
					</c:forEach>
					
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/aa/${vo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach var="vo1" items= "${category}" varStatus="status" >
				<li><a href="${pageContext.request.contextPath}/${authUser.id}?no=${vo1.no}">${vo1.name}</a></li>
				</c:forEach>
				
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>