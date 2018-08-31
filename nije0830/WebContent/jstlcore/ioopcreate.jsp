<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>

<%
	// 문자열 배열 만들기
	String [] ar = {"집게벌레", "노린재목", "장수말벌"};

	// 문자열 리스트 만들기
	List<String> list = new ArrayList<>();
	list.add("황닷거미");
	list.add("황닷게");
	
	// 맵 객체를 생성하고 데이터 저장
	Map<String, Object>map = new HashMap<>();
	map.put("바다전갈", "광익류");
	map.put("채찍전갈", "미갈목");
	
	// , 로 구분된 문자열 만들기
	String insect = "개미,여치,곱등이";
	
	// 결과 페이지에 전달하기 위해 데이터 저장
	request.setAttribute("ar", ar);
	request.setAttribute("list", list);
	request.setAttribute("map", map);
	request.setAttribute("insect", insect);
	
	// 결과 페이지로 이동하기
	RequestDispatcher dispatcher = request.getRequestDispatcher("loop.jsp");
	dispatcher.forward(request, response);

%>