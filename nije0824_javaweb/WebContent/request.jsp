<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 객체의 메소드</title>
</head>
<body>
접속한 클라이언트의 IP주소:<%=request.getRemoteAddr()%><br />
기본 경로:<%=request.getContextPath() %><br />
요청 경로:<%=request.getRequestURI() %><br />

<%
    // 요청 경로에서 기본경로를 제외한 부분 만들기
    // 공통된 부분을 제외할 때는 substring 이용
    String path =
    request.getRequestURI().substring(
    		request.getContextPath().length());
    
%>
<!-- 요청 경로에서 기본 경로를 제외한 부분 출력하기 -->
<!-- 실제 웹 프로젝트 에서는 요청이 많기 때문에 요청 경로를 이용해서
     라우팅을 해야 한다. -->
요청 경로에서 기본경로를 제외한 부분:<%=path %>

</body>
</html>