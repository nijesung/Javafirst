<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl 의 core 기능을 사용하기 위한 태그 라이브러리 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose 테스트</title>
</head>
<body>

<c:choose>
	<c:when test="${param.score >= 90}">
		<h3>당신의 성적은 A 입니다.</h3>
	</c:when>
	<c:when test="${param.score >= 80}">
		<h3>당신의 성적은 B 입니다.</h3>
	</c:when>
	<c:when test="${param.score >= 70}">
		<h3>당신의 성적은 C 입니다.</h3>
	</c:when>
	<c:otherwise>
		<h3>너의 성적은 학고입니다.</h3>
	</c:otherwise>
		
</c:choose>
</body>
</html>