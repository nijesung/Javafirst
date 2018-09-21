<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 뷰 출력</title>
<style>
	h3:hover{
		color:purple;
	}
	span{
		margin:10px;
		border: 3px Solid Purple;
		border-radius:15px;
		float:left;
		width:200px;
		height:80px;
		text-align:center;
	}
	<!-- 마우스 올려놓앗을 때 -->
	span:hover{
		margin:10px;
		border: 3px Solid Purple;
		border-radius:15px;
		float:left;
		width:200px;
		height:80px;
		text-align:center;
	}
</style>
</head>
<body>
	
	<form>
		<div id="msg"></div>
		아이디:<input type="text" id="id"/><br />
		비밀번호:<input type="password" id="pw" /><br />
	</form>


	<a href="excel.xls">엑셀로 출력</a><br />
	<a href="data.pdf">pdf 로 출력</a><br />
	<a href="jsonview.json">jsonview 를 이용한 출력</a><br />
	
	<a href="data.csv">CSV 가져오기</a><br />
	<a href="data.json">JSON 출력</a><br />
	<a href="#" id="ajaxsend">AJAX 로 JSON 가져오기</a><br />
	<div id="disp"></div>

</body>
<!-- ${pageContext.request.contextPath} 를 붙이면 절대 경로로 설정되어 편하다. -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
<!-- 이렇게 줄여서 쓸 수 있다. -->
<!-- $("#ajaxsend").on("click", function(){ -->
	
<!-- }) -->

	<!-- 이 방법이 길지만 속도가 더 빠르다. -->
	document.getElementById("ajaxsend").addEventListener("click", function(){
		$.ajax({
			url:"data.json",
			data:{},
			dataType:"json",
			success:function(data){
				output = ""
				for(imsi in data){
					output += "<span><h3>";
					output += data[imsi].name + "</h3>";
					output += "<p>" + data[imsi].reach;
					output += "</p></span>";
				}
				document.getElementById("disp")
				.innerHTML = output;
			}
		});
	})
	
	var idd = document.getElementById("id");
	var msg = document.getElementById("msg");
	idd.addEventListener("blur", function(){
		$.ajax({
			url:"idcheck",
			data:{"id":idd.value},
			dataType:"json",
			success:function(data){
				if(data.result == "true"){
					msg.innerHTML="사용 가능한 아이디이다.";
					msg.style.color="blue";
				}else{
					msg.innerHTML="사용 불가능한 아이디이다.";
					msg.style.color="red";
				}
			}
	    });
    });
	
	
</script>
</html>