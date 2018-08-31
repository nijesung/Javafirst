<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 불필요한 공백 제거 -->
<%@ page trimDirectiveWhitespaces="true" %>
    <!-- 패키지 import -->
    <%@	page import="java.util.*" %>
<%
     // 테이블 형식의 데이터 만들기
     List<Map<String, Object>> list =
        new ArrayList<>();
     Map<String, Object>map = new HashMap<>();
     map.put("name", "볼칸 위즈데미르");
     map.put("age", "29");
     list.add(map);
     
     map = new HashMap<>();
     map.put("name", "세노브 비르치");
     map.put("age", "17");
     list.add(map);
     
     map = new HashMap<>();
     map.put("name", "셰이팔 쉬이크");
     map.put("age", "18");
     list.add(map);
     
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Map 의 List 출력</title>
</head>
<body>
    <table border="1" align="center" width="400">
       <tr>
          <th>이름</th>
          <th>나이</th>
       </tr>
       <% for(Map imsi : list){%>
          <tr>
             <td><%=imsi.get("name") %></td>
             <td><%=imsi.get("age") %></td>
          </tr>
       
        <%} %>
    
    </table>
</body>
</html>