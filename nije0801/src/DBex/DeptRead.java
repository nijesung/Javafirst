package DBex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeptRead {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ppsm = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이버 클래스 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // 데이터베이스 연결
                    "scott", "tiger");
			
			ppsm = con.prepareStatement("select deptno, dname, loc from dept"); // sql 실행 객체 생성
			
			rs = ppsm.executeQuery(); // select 하는 sql 실행
			
			while(rs.next()) { // 데이터 전체 읽기
				System.out.println(rs.getInt("deptno") + ":");
				System.out.println(rs.getString("dname") + ":");
				System.out.println(rs.getString("loc") + "\n");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}finally {
			try {
				if(rs != null)rs.close();
				if(ppsm != null)ppsm.close();
				if(con != null)con.close();
		}catch(Exception e) {}

	}

		
		
		
   }
}
