<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포함하는 페이지</title>
</head>
<body>
    <p>jsp include 는 다른 페이지의 수행 결과를 포함하는 페이지 란다.</p>
    
    <jsp:include page="sub.jsp" flush="false">
       <jsp:param name="메뚜기 떼" value="10조 마리" />
    </jsp:include>
</body>
</html>