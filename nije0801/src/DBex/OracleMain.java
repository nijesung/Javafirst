package DBex;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleMain {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 사용하는 데이터베이스 마다 로드하는 클래스 이름은 결정되어 있다.
			
			System.out.println("오라클 드라이버 로드 성공"); // 이 코드가 출력되지 않으면 드라이버 이름을 확인해 보고
			                                         // 드라이버 이름이 맞다면 ojdbc6.jar 가 Libraries 에 포함
			                                         // 되어있는지 확인
			
			// 데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					                          "scott", "tiger");
			System.out.println("데이터베이스 연결 성공"); // 이 메시지가 출력되지 않으면 데이터베이스 실행 여부를 확인
			                                       // 데이터베이스 주소가 제대로 입력되었는지 확인 후
			                                       // 계정을 확인 한다
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con != null) { // 데이터베이스가 열려 있으면 데이터 베이스를 닫기
					con.close();
				}
			}catch(Exception e) {}
		}

	}

}
