package DBex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSaveDto {

	public static void main(String[] args) {
		Connection con = null; // 데이터베이스에서 데이터 읽기를 위한 변수
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		ArrayList<Dept> list = new ArrayList<>(); // 읽어온 데이터 저장을 위한 자료구조
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스 드라이버 로드
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", // 데이터베이스 연결
                    "scott", "tiger");
			
			ppsm = con.prepareStatement("select deptno, dname, loc from dept"); // sql 실행 객체 생성
			
			rs = ppsm.executeQuery(); // select 하는 sql 실행
			
			while(rs.next()) { // 데이터 전체 읽기(행 단위로 읽기)
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				
				list.add(dept); // 읽은 하나의 행을 리스트에 저장
			}
			System.out.printf("%10s", "부서번호");
			System.out.printf("%20s", "부서이름");
			System.out.printf("%30s", "부서위치");
			System.out.println();
			for(Dept dept : list) {
				System.out.printf("%10s", dept.getDeptno());
				System.out.printf("%20s", dept.getDname());
				System.out.printf("%30s", dept.getLoc());
				System.out.println();
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try { // 사용을 마친 경우 닫기
				if(rs != null)rs.close();
				if(ppsm != null)ppsm.close();
				if(con != null)con.close();
			}catch(Exception e) {}
		}
		

	}

}

