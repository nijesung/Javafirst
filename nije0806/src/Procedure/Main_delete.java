package Procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main_delete {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement call = null;
		
		try {
			// 데이터베이스 드라이버클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "scott", "tiger");
			
			// 삭제할 Statement 객체 생성
			call = con.prepareCall("{call deleteDeptProc(?)}");
			
			// 물음표에 실제 값 바인딩
			call.setInt(1,  11);

			// 삭제 구문 실행
			int r = call.executeUpdate();
			if(r > 0) {
				System.out.println("삭제 성공");				
			}else {
				System.out.println("삭제 실패");
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(call != null)call.close();
				if(con != null)con.close();
			}catch(Exception e) {}
			
		}
	}

}

