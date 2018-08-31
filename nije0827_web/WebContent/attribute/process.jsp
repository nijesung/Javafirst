<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
       // 파라미터 읽기
       request.setCharacterEncoding("utf-8");
   
       String id = request.getParameter("id");
       String pw = request.getParameter("pw");
       
       // 콘솔에 읽은 파라미터 출력
       System.out.println(id);
       System.out.println(pw);
       
       // 결과 페이지로 이동
       
       // 포워딩 으로 결과 페이지로 이동 : URL 이 변경되지 않는다.
       /*
       RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
       dispatcher.forward(request, response);
       */
       
       /*
       // 리다이렉트 로 이동 : URL 이 변경된다.
       
       // 리퀘스트에 저장 : 소멸된다. (리다이렉트 로 이동했기 때문이다)
       request.setAttribute("data01", "리퀘스트");
       // 세션에 저장 : 이동을 해도 유지가 된다.
       session.setAttribute("data02", "세션");
       response.sendRedirect("result.jsp");
       */
       
       // 포워딩으로 이동
       // 리퀘스트에 저장 : 유지된다.
       request.setAttribute("data01", "리퀘스트");
       // 세션에 저장 : 이동을 해도 유지가 된다.
       session.setAttribute("data02", "세션");
       
       RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
       dispatcher.forward(request, response);
       
       
       
       
   %>
</body>
</html>