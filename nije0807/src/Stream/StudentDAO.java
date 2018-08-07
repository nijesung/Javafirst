package Stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	// StudentDAO 클래스에서 모든 데이터를 가져오는 메소드
	public List<StudentVO> fetch(){
		// 리턴랄 리스트를 생성
		// List 를 리턴해야 하는 경우에는 null 을 리턴하지 않는 것이 좋다. (1개 짜리 리턴할 때와 다른 점)
		// List 는 특별한 경우가 아니라면 빠른 열거를 이용하여 접근하는데 null 이면 널포인터엑셉션이 발생한다.
		// null 을 만들지 않기 위해 인스턴스를 생성해서 리턴한다.
		List<StudentVO> list = new ArrayList<StudentVO>();
		
	    Connection con = null;
	    PreparedStatement ppsm = null;
	    ResultSet rs = null;
	    
	    try { // 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "scott", "tiger"); // 데이터베이스 연결
			// sql 실행 객체 생성(한 줄에 쓰고 띄어쓰는 것이 오류를 줄일 수 있다)
			ppsm = con.prepareStatement("select studnum, name, department, score, age, gender"
					+ " from student");
			// SQL 실행
			rs = ppsm.executeQuery();
			
			// 데이터가 여러 개면 while 을 돌린다
			while(rs.next()) {
			    StudentVO vo = new StudentVO(
						rs.getString("studnum"), rs.getString("name"),
						rs.getString("department"), rs.getInt("score"),
						rs.getInt("age"), rs.getString("gender"));
			    list.add(vo);
			}
	    }catch(Exception e) {
	    	// 예외 내용 확인을 위해서 작성
	    	System.out.println("읽기 오류: " + e.getMessage());
	    	// 예외의 위치를 알기 위해서 작성
	    	e.printStackTrace();
	    }finally {
	    	try {
	    		if(rs != null)rs.close();
	    		if(ppsm != null)ppsm.close();
	    		if(con != null)con.close();
	    	}catch(Exception e) {}
	    }
    
	
		
		
		return list;
	}

}
