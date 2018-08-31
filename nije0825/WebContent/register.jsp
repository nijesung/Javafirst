<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
   <%@ page import="java.util.*, java.io.*" %>
   <%
       // 문자열을 파일에 기록
       // 접속한 아이피 주소 가져오기
       String ip = request.getRemoteAddr();
       Date date = new Date();
       
       Calendar cal = new GregorianCalendar();
       int year = cal.get(Calendar.YEAR);
       int month = cal.get(Calendar.MONTH) + 1; // 컴퓨터는 월을 0부터 시작하기 때문에 +1 을 더해주어야 한다.
       int day = cal.get(Calendar.DATE);
       String filename = year + "" + month + "" + day +".txt";
       
       // 기록할 파일 스트림 객체 만들기
       // true 를 주면 덮어씌운다.
    // PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/a503-11/Documents/"+"log.txt", true));
       PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/a503-11/Documents/"+"filename.txt", true));
       pw.println(ip+"-"+date+"\n");
       pw.flush();
       pw.close();
   
   %>


   <%  // web.xml 파일에 설정한 초기화 파라미터 읽기
       String dbname = application.getInitParameter("dbname");
       // 읽은 내용을 화면에 출력
       out.println("읽어온 파라미터:" + dbname + "<br />");
   
   %>



   <h2 align="center">회원가입</h2>
   <form action="registerreceive.jsp" method="post">
   <table align="center" cellspacing="10">
   
   <tr>
      <td width="100" align="right">이메일</td>
      <td width="200">
      <input type="email" name="email" size="30"/></td>
   </tr>
   
   <tr>
      <td width="100" align="right">비밀번호</td>
      <td width="200">
      <input type="password" name="password" size="30"/></td>
   </tr>
   
   <tr>
      <td width="100" align="right">비밀번호확인</td>
      <td width="200">
      <input type="password" size="30"/></td>
   </tr>
   
   <tr>
      <td width="100" align="right">닉네임</td>
      <td width="200">
      <input type="text" name="nickname" size="30"/></td>
   </tr>
   
   <tr>
      <td width="100" align="right">전화번호</td>
      <td width="200">
      <input type="tel" name="phone" size="11" maxlength="11"/></td>
   </tr>
   
   <tr>
      <td width="100" align="right">자기소개</td>
      <td width="200">
      <textarea cols="40" rows="10" name="description"></textarea></td>
   </tr>
   
   <tr>
      <td closapn="2" align="center">
      <input type="submit" value="회원가입"/>
      <input type="reset" value="작성취소"/>
      </td>
   </tr>
   
   <fieldset>
         <legend>종족</legend>
         <input type="checkbox" name="kind"
         value="human"/>인간
         <input type="checkbox" name="kind"
         value="lizardman"/>도마뱀인간
         <input type="checkbox" name="kind"
         value="Aether"/>에테르
         <input type="checkbox" name="kind"
         value="insect"/>벌레
   </fieldset>
   
   </table>
   </form>
</body>
</html>