<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배열과 리스트 생성</title>
</head>
<body>
    <%  
        List<String> list = new ArrayList<>();
    	list.add("곱등이");
    	list.add("폭탄먼지벌레");
    	list.add("송장벌레");
    	request.setAttribute("list", list);
        
        /*
    	// 배열을 생성 
    	String [] ar = {"길앞잡이", "바퀴벌레", "톡토기"};
    	// 배열의 데이터를 List 라는 이름으로 request 객체에 저장
    	request.setAttribute("list", ar);
    	*/
    	
    	// 결과를 출력할 페이지로 포워딩
    	RequestDispatcher dispatcher = request.getRequestDispatcher("listdisplay.jsp");
    	dispatcher.forward(request, response);
    %>
</body>
</html>