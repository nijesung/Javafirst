<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta charset="utf-8" />
	<title>JSP 기타</title>
</head>
<body>
<a href="mailsend.do">메일 보내기</a>
<input type="button" id="proxy" value="proxy 사용"/><br />

<input type="button" id="push" value="push 시작"/><div id ="disp"></div>
<br />

닉네임<input type="text" id="nick" size="30" /><br />
보내는 내용<input type="text" id="message" size="50" /><br />
<input type="button" id="send" value="보내기" /><br />
받은 내용<textarea id="print" cols="80" rows="15"></textarea>
<br />


</body>
<!-- jquery 사용을 위한 링크 설정 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	var websoket = new WebSocket("ws://localhost:8080//nije0911etc//websocket");
	// 에러가 발생한 경우
	websocket.onerror = function(event){
		onError(event)
	}
	// 처음 연결한 경우
	websocket.onopen = function(event){
		onOpen(event)
	}
	// 메시지가 온 경우
	websocket.onmessage = function(event){
		onMessage(event)
	}
	
	function onError(event){
		alert(event.data);
	}
	function onOpen(event){
		document.getElementById("print").value = "연결 되었다."
	}
	function onMessage(event){
		var print = document.getElementById("print")
		print.value = event.data + "\n" + print.value;
	}
	document.getElementById("send").addEventListener("click", function(){
		websocket.send(document.getElementById("nick").value + ":" + document.getElementById("message").value )
	})


	document.getElementById("push").addEventListener("click", function(){
		// 웹 푸시 객체 만들기
		var eventsrc = new EventSource("push.do");
		// 메시지가 왔을 때 호출될 함수를 등록
		eventsrc.addEventListener("message", function(result){
			document.getElementById("disp").innerHTML = result.data
		})
	})


	document.getElementById("proxy").addEventListener("click", function(){
		$.ajax({url:'proxy.do',
				dataType:'xml',
				success:function(data){
					// city 태그 찾아오기
					var cities = $(data).find(city);
					// jquery 의 배열 순회 - data 태그를 찾아서 순회
					// index 는 순회하는 배열의 인덱스이고 item 은 데이터 이다.
					$(data).find('data').each(function(index, item){
						var output = ''
						if(index % 6 == 0){
							output += '<div><h2>'
							+ $(cities[index/6]).text()
							output += '</h2>'
						}
						output += '<p>' +
							$(this).find('tmEf').text() + '</p>'
						output += '<p>' +
							$(this).find('wf').text() + '</p>'
						if(index % 6 == 0){
							output += '</div>'
						}
						// body 태그 안에 기존 내용과 함께 출력
						$('body').html($('body').html() + output)
					})
				}
		})
	});
</script>
</html>




