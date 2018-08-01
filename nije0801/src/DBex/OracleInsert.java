package DBex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OracleInsert {

	public static void main(String[] args) {
		Connection con = null; // 데이터베이스 연결 변수
		
		PreparedStatement ppsm = null; // SQL 실행 변수
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 클래스 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "scott", "tiger");
			
		 //	ppsm = con.prepareStatement("insert into dept(deptno, dname, loc) " + // SQL 실행 객체를 생성
		 //	                            "values(60, '집게벌레', '초안산')"); // 데이터 삽입
			// SQL 을 실행 - select 를 제외한 구문 실행
			 
			 
		 //	ppsm = con.prepareStatement("delete from dept where deptno = 50"); // 데이터 삭제
			
			// dept 테이블에서 deptno 가 10번인 데이터의 loc를 초안산 으로 변경
			ppsm = con.prepareStatement("update dept set loc='초안산' where deptno = 10");
					
			int r = ppsm.executeUpdate(); // r에 저장되는 값은 영향받은 행의 개수
			if(r > 0) {
				System.out.println("변경 성공"); // 성공 여부 출력
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(ppsm != null) ppsm.close();
				    ppsm.close();
				if(con != null) { // 데이터베이스가 열려 있으면 데이터 베이스를 닫기
					con.close();
				}
			}catch(Exception e) {}
		}

	}

}
