<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>

<%
	JSONObject obj = new JSONObject();
	obj.put("name", "오빈스 생 프루");
	
	JSONArray ar = new JSONArray();
	ar.put("오빈스 생 프루");
	ar.put("도미닉 레예스");
	ar.put("볼칸 위즈데미르");
	ar.put("에이베르톤 테이세이라");
%>
<%=ar%>
