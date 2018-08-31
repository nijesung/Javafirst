<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    // 문자열을 저장할 수 있는 List 를 만들고 데이터를 저장
    List<String> list =
        new ArrayList<String>();
    list.add("이구아나");
	list.add("왕도마뱀");
	list.add("워터모니터");
	list.add("독도마뱀");
	list.add("바실리스크도마뱀");
	list.add("테구");
	
	for(String imsi : list){
		out.println("<p>" + imsi + "</p>");
	}
%>

</body>
</html>