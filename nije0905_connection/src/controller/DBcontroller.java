package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

import vo.Buy;


@WebServlet("*.db")
public class DBcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DBcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 주소에서 공통된 부분을 제외한 부분을 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() +1);
		
		switch(command) {
		
		case "selectone.db":
			Connection con05 = null;
			PreparedStatement ppsm05 = null;
			ResultSet rs05 = null;
			List<Buy> list02 = new ArrayList<Buy>();
			// 데이터 1개를 리턴하는 경우에는 변수만 생성
			Buy buy05 = null;
			
			try {
				//드라이버 클래스 로드
				Class.forName(
					"com.mysql.jdbc.Driver");
				//데이터베이스 연결
				con05 = 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/itggangpae?characterEncoding=UTF-8&serverTimezone=UTC", "root", "********");
				ppsm05 = con05.prepareStatement(
					"select * from buytbl where num=?");
				String num = request.getParameter("num");
				// 문자열을 정수로 변환하여 ? 에 바인딩
				ppsm05.setInt(1, Integer.parseInt(num));
				
				//sql을 실행하고 결과 저장하기
				rs05 = ppsm05.executeQuery();
				
				//리턴된 데이터를 읽어서 list에 저장
				if(rs05.next()) {
					buy05 = new Buy();
					buy05.setNum(rs05.getInt("num"));
					buy05.setUserid(rs05.getString("userid"));
					buy05.setProductname(rs05.getString("productname"));
					buy05.setGroupname(rs05.getString("groupname"));
					buy05.setPrice(rs05.getInt("price"));
					buy05.setAmount(rs05.getInt("amount"));
					
					list02.add(buy05);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				
			}finally {
				try {
					if(rs05 != null)rs05.close();
					if(con05 != null)con05.close();
					if(ppsm05 != null)ppsm05.close();
				}catch(Exception e) {}
			}
			
				System.out.println(buy05);
			
			break;
		
		case "selectlist.db":
			Connection con04 = null;
			PreparedStatement ppsm04 = null;
			ResultSet rs04 = null;
			//select 구문은 결과를 저장할 변수가 필요
			List<Buy> list = new ArrayList<Buy>();
			try {
				//드라이버 클래스 로드
				Class.forName(
					"com.mysql.jdbc.Driver");
				//데이터베이스 연결
				con04 = 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/itggangpae?characterEncoding=UTF-8&serverTimezone=UTC", "root", "********");
				ppsm04 = con04.prepareStatement(
					"select * from buytbl");
				
				//sql을 실행하고 결과 저장하기
				rs04 = ppsm04.executeQuery();
				
				//리턴된 데이터를 읽어서 list에 저장
				while(rs04.next()) {
					Buy buy = new Buy();
					buy.setNum(rs04.getInt("num"));
					buy.setUserid(rs04.getString("userid"));
					buy.setProductname(rs04.getString("productname"));
					buy.setGroupname(rs04.getString("groupname"));
					buy.setPrice(rs04.getInt("price"));
					buy.setAmount(rs04.getInt("amount"));
					
					list.add(buy);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				
			}finally {
				try {
					if(rs04 != null)rs04.close();
					if(con04 != null)con04.close();
					if(ppsm04 != null)ppsm04.close();
				}catch(Exception e) {}
			}
			//System.out.println(list);
			for(Buy buy : list) {
				System.out.println(buy);
			}
			break;
		
		case "delete.db":
			Connection con03 = null;
			PreparedStatement ppsm03 = null;
			try {
				// 드라이버 클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				con03 =
						DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/nije?characterEncoding=UTF-8&serverTimezone=UTC", "root", "xjatmvk9");
				ppsm03 = con03.prepareStatement("delete from where userid=?");
				
				
				// sql 을 실행하고 결과 저장하기
				int result03 = ppsm03.executeUpdate();
				if(result03 > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("에러는 없지만 삭제는 하지 않았다");
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(con03 != null)con03.close();
					if(ppsm03 != null)ppsm03.close();
				}catch(Exception e) {}
			}
			break;
		
		case "insert.db":
			Connection con01 = null;
			PreparedStatement ppsm = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con01 =
						DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/nije?characterEncoding=UTF-8&serverTimezone=UTC", "root", "xjatmvk9");
				ppsm = con01.prepareStatement("insert into usertbl(userid, name, birthyear, addr, mobile, mdate) values(?,?,?,?,?,?)");
				
				ppsm.setString(1, "nije");
				ppsm.setString(2, "테렉 사피에딘");
				ppsm.setString(3, "1986");
				ppsm.setString(4, "위스콘신");
				ppsm.setString(5, "01018285858");
				ppsm.setDate(6, new Date(5, 11, 3));
				
				// sql 을 실행하고 결과 저장하기
				int result = ppsm.executeUpdate();
				if(result > 0) {
					System.out.println("삽입 성공");
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(con01 != null)con01.close();
					if(ppsm != null)ppsm.close();
				}catch(Exception e) {}
			}
			break;
		
		case "mysql.db":
		//드라이버 클래스 로드
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// 데이터베이스 연결
				Connection con = 
						DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/nije?characterEncoding=UTF-8&serverTimezone=UTC", "root", "xjatmvk9");
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "oracle.db":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@192.168.10.101:1521:xe", "user11", "user11");
				System.out.println(con);
				con.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();					
			}
		
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
