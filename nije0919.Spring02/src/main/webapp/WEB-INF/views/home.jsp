<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" 
	cellpadding="3px">
		<tr style="background:#C98FED">
			<th width="80">선수 id</th>
			<th width="200">선수 이름</th>
			<th width="120">선수 폰번호</th>
		</tr>
		<c:forEach var="ufc" items="${list}">
			<tr style="background:#EDEDED">
				<td><a href="detail?ufcid=${ufc.ufcid}">${ufc.ufcname}</a></td>
			</tr>	
		</c:forEach>	
	</table>
</body>
</html>
