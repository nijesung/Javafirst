<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 이동 - HTML 에서 요청</title>
</head>
<body>
    <a href="process.jsp?email=nije@gmail.com&pw=123123">process 로 이동</a><br />
    <form action="process.jsp" id="myform" method="post">
        이메일<input type="email" name="email"/><br />
        비밀번호<input type="password" name="pw" /><br />
        <input type="submit" value="전송"/>
    </form>
    
    <input type="button" value="location 이용"
    id="btn01" />
    <input type="button" value="window 이용"
    id="btn02" />
    <input type="button" value="뒤로 가기"
    id="back" />
    <input type="button" value="새로 고침"
    id="reload" />
    <input type="button" value="폼 데이터 전송"
    id="formsubmit" />
    <input type="button" value="ajax"
    id="ajax" />
    
</body>

<script>
      var btn01 = document.getElementById("btn01")
      var btn02 = document.getElementById("btn02")
      var back = document.getElementById("back")
      var reload = document.getElementById("reload")
      var formsubmit = document.getElementById("formsubmit")
      var ajax = document.getElementById("ajax")
      
      // process.jsp 를 요청
      btn01.addEventListener("click", function(e){
    		 location.href="process.jsp?email=관리자"
      });
      btn02.addEventListener("click", function(e){
     		 window.location="process.jsp"
      });
      back.addEventListener("click", function(e){
  		 history.back();
      });
      // 새로 고침 - 현재 URL 을 다시 요청
      reload.addEventListener("click", function(e){
   		 location.reload();
      });
      formsubmit.addEventListener("click", function(e){
    	  document.getElementById("myform").submit();
      });
      ajax.addEventListener("click", function(e){
    	  // ajax 요청 객체 생성
    	  var request = new XMLHttpRequest();
    	  // 요청을 생성하고 요청
       // request.open('GET', 'process.jsp?email=nije@gmail.com');
    	  
    	  // ajax 에서 POST 방식으로 파라미터 전송
    	  request.open('POST', process.jsp')
    	  // 전송방식을 form 으로 설정해서 post 방식으로 전송한다.
    	  requset.setRequesHeader("Content=type", "application/x-www-form-urlencoded");
    	  request.send('email=nije@gmail.com');
    	  // ajax 요청에 성공하면 호출되는 콜백 메소드 등록
    	  request.onreadystatechange = function(){
    		  if(request.readyState == 4){
    			  if(request.status >= 200 && request.status < 300){
    				  alert("요청 성공");
    			  }
    		  }
    	  }
      });
      
</script>
</html>