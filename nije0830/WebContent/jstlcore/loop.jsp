<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<!-- items 자리에 ar, list, map, insect 를 번갈아 가며 대입하고 확인 해 보자 -->
	<c:forEach var="temp" items="${map}">
		<li>${temp}</li>
	</c:forEach>
	</ul>
</body>
</html>