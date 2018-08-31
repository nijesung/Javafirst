<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 에러 페이지</title>
</head>
<body>
    <p>2초 후에 메인페이지로 이동한다.</p>
    <h3>404 에러가 발생했다.</h3>
</body>
<script>
    setTimeout(function(){
    	location.href="javabean/beancreate.jsp"
    }, 2000)

</script>
</html>