<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="header">
			<h1>MySite</h1>
			<ul>
			<c:choose>
				<c:when test="${empty authUser}">
				<li><a href="${pageContext.servletContext.contextPath}/user/login">로그인</a><li>
				<li><a href="${pageContext.servletContext.contextPath}/user/join">회원가입</a><li>
				<li><a href="${pageContext.servletContext.contextPath}/user/modify">회원정보수정</a><li>
				</c:when>
				<c:otherwise>
					<c:if test="${authUser.name=='admin'}">
				<li><a href="${pageContext.servletContext.contextPath}/admin/main">홈페이지관리</a><li>
				</c:if>
				<li><a href="${pageContext.servletContext.contextPath}/user/modify">회원정보수정</a><li>
				<li><a href="${pageContext.servletContext.contextPath}/user/logout">로그아웃</a><li>
				<li>${authUser.name}님 안녕하세요 ^^;</li>	
				</c:otherwise>
			</c:choose>
			</ul>
		</div>