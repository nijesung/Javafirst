package DBex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeptnoEx {

	public static void main(String[] args) {
		Connection con = null;
		
		PreparedStatement ppsm = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("deptno 번호 입력: "); // 삭제할 deptno 번호를 입력
		int deptno = sc.nextInt();
		System.out.println("부서번호: " + deptno);
		
		sc.close(); // 여기까지가 입력받는 부분
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 클래스 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // 데이터베이스 연결
                    "scott", "tiger");
			System.out.println("접속 성공"); // 연결 되었나 확인
			
			con.setAutoCommit(false); // autocommit 해제
			
		    ppsm = con.prepareStatement("delete from dept where deptno = ?"); // SQL 실행객체 생성
		    ppsm.setInt(1, deptno); // ? 가 있으면 데이터를 바인딩
			
			int r = ppsm.executeUpdate(); // SQL 실행
			if(r > 0) { // 실행하고 나면 영향받은 행의 개수를 리턴한다. 조건에 맞는 데이터가 없으면 실패하는 것이 아니라 삭제하는 행의
				      // 개수가 0개이다. 실패하면 예외가 발생하므로 catch 로 간다.
				System.out.println("삭제 성공");
			    con.commit(); // 오토커밋 해제 시 
			}
			else
			    System.out.println("조건에 맞는 데이터가 없음");
			
		}catch(Exception e) {
			try { // 오토커밋 해제 시 작업도중 예외가 발생한 경우 rollback 을 호출
		//	con.rollback(); {} // 오토커밋 해제 시
			System.out.println(e.getMessage()); // 예외의 내용을 출력
			e.printStackTrace(); // 예외가 발생한 지점을 역추적
		}finally { 
			try {
				if(ppsm != null)ppsm.close();
				if(con != null)con.close();
			}catch(Exception e2) {}
		}
		
		}

		
     }
}
