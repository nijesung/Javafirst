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
<%  /*
	Map <String, Object> map = new HashMap<>();
	map.put("name", "관리자");
	map.put("age", 99);
	
	// request 에 저장
	request.setAttribute("data", map);
	*/
	
	vo.Insect insect = new vo.Insect();
	insect.setName("집게벌레");
	insect.setSize(2);
	request.setAttribute("data", insect);
	
	// 결과를 출력할 페이지로 포워딩
	RequestDispatcher dispatcher = request.getRequestDispatcher("mapdisplay.jsp");
	dispatcher.forward(request, response);

%>

</body>
</html>