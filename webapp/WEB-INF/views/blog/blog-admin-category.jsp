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
		<div id="header">
			<h1>Spring 이야기</h1>
			<ul>
				<li><a href="">로그인</a></li> 
				<li><a href="">로그아웃</a></li>
				<li><a href="">블로그 관리</a></li>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="">기본설정</a></li>
					<li class="selected">카테고리</li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id}/admin/write1">글작성</a></li>
				</ul>
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>방명자</th>
		      			<th>작성일</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
						<c:forEach var="vo" items= "${list}" varStatus="status" >
					<tr>				
					<td>${vo.no}</td>
					<td>${vo.name}</td> 
					<td>${vo.regDate}</td>
					<td>${vo.content}</td>
					<td><a href="${pageContext.request.contextPath }/${authUser.id}/delete?no=${vo.no}&blogId=${authUser.id}">
					<img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></a></td>
						
					</tr>
					</c:forEach>
				</table>
      	
      			<form class="category-form" method="get" action="${pageContext.request.contextPath}/${authUser.id}/add">	
      			<input type='hidden' name="blogId" value="${authUser.id}">
      			<h4 class="n-c" >새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add" >
		      		<tr>
		      			<td class="t" >카테고리명</td>
		      			<td><input type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="content" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>