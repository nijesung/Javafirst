<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<div id="registermag">${registermsg}</div>
	<form action="insert" method="post"
	id="registerform"> <!-- 애매할 땐 포스트 -->
		<label for="email">이메일</label>
		<input type="email" name="email" id="email"
		required="required" />
		<span id="emailmsg"></span>
		<br />
		
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw"
		required="required" /><br />
		
		<label for="password">이름</label>
		<input type="text" name="name" id="name"
		required="required" /><br />
		
		<label for="phone">전화번호</label>
		<input type="tel" name="phone" id="phone"
		required="required" /><br />
		
		<label for="addr">주소</label>
		<input type="text" size="100" name="addr" id="addr"
		required="required" /><br />
		
		<input type="submit" value="회원가입" />
		<input type="button" value="메인으로" 
		onclick="location.href='../'"/>
		
		
	</form>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
	var email = document.getElementById("email");
	var emailmsg = document.getElementById("emailmsg");
	// 이메일 중복 여부를 저장할 변수
	var emailcheck = false;
	
	email.addEventListener("blur", function(){
		emailcheck = false;
		// 이메일에 입력된 값 가져오기
		var value = email.value
		// elert("포커스 이동")
		
		$.ajax({
			url:'emailcheck',
			data:{'email':value},
			dataType:'json',
			success:function(result){
				if(result.result == true){
					emailmsg.innerHTML =
						'이미 사용하고 있는 아이디입니다.'
					emailmsg.style.color = "red";
					emailcheck = false;
				}else{
					emailmsg.innerHTML =
						'사용 가능한 아이디입니다.'
					emailmsg.style.color = "blue";
					emailcheck = true;
				}
			}
		});
	});
	// 폼의 데이터를 전송할 때
	document.getElementById("registerform").addEventListener("submit", function(e){
		var event = e || window.event;
		if(emailcheck == false){
			alert("이메일 중복 체크를 하도록 해라")
			emailmsg.innerHTML="이메일 중복 체크를 다시 하도록 해라"
			// 이벤트 발생 시 기본적으로 수행하는 내용 하지 않기
			// 폼의 데이터가 전송되지 않는다.
			email.focus();
			event.preventDefault();
		}
	})

</script>
</html>