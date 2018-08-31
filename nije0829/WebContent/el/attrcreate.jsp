<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 데이터 저장
    request.setAttribute("id", "insect");
    request.setAttribute("score", 666);
    
    // 결과 페이지로 포워딩
    /*
    RequestDispatcher dispatcher = request.getRequestDispatcher("attrdisplay.jsp");
    dispatcher.forward(request, response);
    */
    
    // 결과 페이지로 리다이렉트 - request	의 데이터는 전달 안됨
    // 리다이렉트 할 때는 세션에 저장하여야 한다.
    session.setAttribute("id", "insect");
    session.setAttribute("score", 666);
    response.sendRedirect("attrdisplay.jsp");
    
    %>
    
    