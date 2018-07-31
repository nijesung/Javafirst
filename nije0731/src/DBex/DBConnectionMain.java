package DBex;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionMain {

	public static void main(String[] args) {
		// 사용하고자 하는 드라이버 클래스를 로드
		// 데이터베이스 종류에 따라 다름
		// 데이터베이스 연결 변수 선언
		
		Connection con = null; // 반드시 Close() 를 호출해야 하므로 finally 에서 Close() 를 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"scott", "tiger");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(con != null) { // 연결이 되어 있으면 반드시 연결 해제
				try {
					con.close();
				}catch(Exception e) {}
			}
		}

	}

}
