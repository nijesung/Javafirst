package DBex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding {

		public static void main(String[] args) {
			Connection con = null; // 데이터베이스 연결 변수
			
			PreparedStatement ppsm = null; // SQL 실행 변수
			
			Scanner sc = new Scanner(System.in); // 키보드로부터 입력받을 수 있는 객체를 생성
			
			System.out.print("부서번호: ");
			int deptno = sc.nextInt();
			
			System.out.print("부서이름: ");
			sc.nextLine(); // 이전에 남아있던 Enter 를 제거하기 위한 코드이다.
			String dname = sc.nextLine();
			
			System.out.print("지역: ");
			String loc = sc.nextLine();
			
			sc.close();
			
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 클래스 로드
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
	                    "scott", "tiger");
		
				String sql = "insert into dept(deptno, dname, loc) " + // ppsm 생성
	                                        "values(?,?,?)";
				ppsm = con.prepareStatement(sql);  // ppsm 생성- 다른 데이터를 바인딩할수있는 생성
				
				ppsm.setInt(1, deptno); // 데이터 바인딩
				ppsm.setString(2, dname);
				ppsm.setString(3, loc);
				
				int r = ppsm.executeUpdate();
				if(r > 0) {
					System.out.println("삽입 성공");
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
