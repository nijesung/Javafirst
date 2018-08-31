<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3><%=exception.getMessage() %></h3>
    <p>에러가 발생했다. 조속히 조치 바란다.</p>
</body>
</html>