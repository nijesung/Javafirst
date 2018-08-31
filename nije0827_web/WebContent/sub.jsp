<!-- 사용하는 프로그래밍 언어를 설정하고 출력하는 파일의 종류를 설정하는 구문
     현재 페이지 코딩의 인코딩 방식을 설정한다.
     출력하는 jsp 파일의 경우 이 태그는 삭제하면 안 된다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p>다른 페이지에 포함될 공통된 내용을 가지고 있는 파일</p>

<p>파라미터 출력:<%=request.getParameter("메뚜기 떼") %></p>
