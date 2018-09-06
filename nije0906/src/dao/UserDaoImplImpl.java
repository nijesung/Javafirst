package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Fighter;

public class UserDaoImplImpl implements UserDao {
	// 데이터베이스 연결을 위한 변수
	private Connection con;
	private PreparedStatement ppsm;
	private ResultSet rs;
	
	public UserDaoImplImpl() {
		try {
			// MySQL 인 경우 이 부분을 다르게 작성해야 한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static UserDao userDao;
	
	public static UserDao sharedInstance() {
		if(userDao == null) {
			userDao = new UserDaoImplImpl();
		}
		return userDao;
	}

	@Override
	public Fighter login(Fighter fighter) {
		
		// 넘어온 파라미터를 출력
		
		// email 과 pw 가 제대로 저장되었는지 확인하는 작업
		System.out.println("넘어온 데이터: " + fighter);
		
		Fighter user = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.10.101:1521:xe", "user11", "user11");
			
			// Statement 인스턴스를 생성하고 SQL	실행
			ppsm = con.prepareStatement(
					"select email, name from fighter where trim(email)=? and trim(pw)=?");
			// ? 에 값 채우기
			ppsm.setString(1, fighter.getEmail().trim());
			ppsm.setString(2, fighter.getPw().trim());
			
			// SQL 실행(select 일 때는 rs 로 받는다.
		    rs = ppsm.executeQuery();
		    
		    // 결과를 읽기 
		    // 읽은 데이터가 있는 경우에 user 에 인스턴스를 생성해서 대입
		    // 일긍ㄴ 데이터가 없으면 user 는 null
		    if(rs.next()) {
		    	// 인스턴스를 생성하고 결과를 저장
		    	user = new Fighter();
		    	user.setEmail(rs.getString("email"));
		    	user.setName(rs.getString("name"));
		    }
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
			if(rs != null)rs.close();
			if(ppsm != null)ppsm.close();
			if(con != null)con.close();
			}catch(Exception e) {}
		}
		
		// email 과 pw 가 일치하는 데이터가 없으면 null 이 리턴되고
		// 일치하는 데이터가 있으면 인스턴스를 생성해서 리턴
		
		// 리턴하는 결과 확인
		System.out.println("리턴하는 데이터: " + user);
		return user;
	}
}
