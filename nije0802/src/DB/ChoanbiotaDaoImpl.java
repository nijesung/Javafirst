package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChoanbiotaDaoImpl implements ChoanbiotaDao {
	
	
	private Connection con; // 모든 메소드에서 공통으로 사용할 변수 선언
	private PreparedStatement ppsm;
	private ResultSet rs;
	
	private void connect() { // 데이터베이스 연결을 수행해주는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                    "scott", "tiger"); // 데이터베이스 연결
		}catch(Exception e) {
		    System.out.println(e.getMessage());
		    e.printStackTrace();
	    }
    }
		
		private void close() {
		try {
			if(rs != null)rs.close();
			if(ppsm != null)ppsm.close();
			if(con != null)con.close();	
		}
		catch(Exception e) {}
	  }
	
		
	

	
	
	// sql: select max(num) from // Choanbiota
	private int getMaxNum() { // 가장 큰 num 을 찾아오는 메소드
		int result = 0; // 무의미한 값을 주면 된다
		
		/*
		Connection con = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null; // select 구문의 결과를 저장하기 위한 변수
		*/
		
		try {
			connect();
		
			
			ppsm = con.prepareStatement("select max(num) from Choanbiota"); // 가장 큰 글번호를 찾아오는 sql 을 실행하는 객체 생성
			rs = ppsm.executeQuery(); // sql 실행
			
			while(rs.next()) { // 결과 읽기
				result = rs.getInt(1); // select 절의 첫번째 컬럼의 값을 정수로 읽어서 result 에 저장
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
				
		}
		
		
		return result;
	}

	@Override
	public boolean insertChoanbiota(Choanbiota choanbiota) { // 데이터삽입 메소드
		boolean result = false;
		
		try {
			int maxNum = getMaxNum();
			
			connect();
			
			ppsm = con.prepareStatement(
							"insert into Choanbiota(num, population, specific_name, detect_day) " +
                            "values(?,?,?,?)");
		 // ppsm = con.prepareStatement(sql);
                            
		
		ppsm.setInt(1, maxNum() + 1);// 물음표에 값을 바인딩 // 가장 큰 번호 + 1 으로 설정
		ppsm.setInt(2, choanbiota.getPopulation());
		ppsm.setString(3, choanbiota.getSpecific_name());
		ppsm.setDate(4, choanbiota.getDetect_day());
		
		// select 를 제외한 구문은 executeUpdate 로 실행
		// 실행결과를 영향받은 행의 개수를 정수로 리턴
		int r = ppsm.executeUpdate();
		if(r == 1) {
			result = true;
		}
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
				close();
		}
		return result;
	}

	private int maxNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateChoanbiota(Choanbiota choanbiota) {
		boolean result = false;
		connect();
		try {
			
			// SQL 생성
			
			/*
			ppsm = con.prepareStatement("update 테이블이름" + "set 수정할 내용"
					                   + "where 조건");
					                   */
			ppsm = con.prepareStatement
					("update choanbiota "
							+ "set specific_name=?,population=?, detect_day=? "
							+ "where num=?");
			
			ppsm.setString(1, choanbiota.getSpecific_name());
			ppsm.setInt(2, choanbiota.getPopulation());
			ppsm.setDate(3, choanbiota.getDetect_day());
			ppsm.setInt(4, choanbiota.getNum());
			
			
			int r = ppsm.executeUpdate(); // sql 실행
			if (r > 0) { // 결과 사용
				result = true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close(); // 클로우즈는 항상 맨 마지막에
		return result;
	}

	@Override
	public boolean deleteChoanbiota(int num) {
		boolean result = false;
		connect();
		try {
			ppsm = con.prepareStatement // ora 에러가 발생하면 무조건 이곳이다
					("delete from choanbiota "
							+ "where num=?");
			ppsm.setInt(1, num);
			int r = ppsm.executeUpdate();
			if(r > 0) {
				result = true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		close();
		return result;
	}
    
	@Override
	public List<Choanbiota> allChoanbiota() {
        List<Choanbiota> list = new ArrayList<Choanbiota>(); // 읽어온 데이터를 저장하기 위한 리스트 생성
        connect();
        try {
        	ppsm = con.prepareStatement // Choanbiota 테이블에 있는 전체 데이터를 가져오는 SQL 실행 객체 생성
        			("select * from choanbiota");
        	/*
					("update choanbiota "
							+ "set specific_name=?,population=?, detect_day=? "
							+ "where num=?");
        	("select specific_name, population, detect_day, where num");
        	*/
        	rs = ppsm.executeQuery(); // select 구문 실행
        	
        	// 반복문을 이용해서 데이터를 읽어서 List 에 저장
        	while(rs.next()) {
        		Choanbiota choanbiota  = new Choanbiota();
        		choanbiota.setNum(rs.getInt("num"));
        		choanbiota.setPopulation(rs.getInt("population"));
        		choanbiota.setSpecific_name(rs.getString("specific_name"));
        		choanbiota.setDetect_day(rs.getDate("detect_day"));
        		
        		list.add(choanbiota); // 읽은 데이터를 리스트에 저장
        	}
        	
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        
        
        
        close();
        return list;
	}

	@Override
	public List<Choanbiota> specific_nameChoanbiota(String specific_name) {
		List<Choanbiota> list = new ArrayList<Choanbiota>(); // 읽어온 데이터를 저장하기 위한 리스트 생성
        connect();
        try { // Choanbiota 테이블의 specific_name 컬럼에  specific_name 의 값이 포함된 데이터를 조회하는 SQL
        	// 물음표에 데이터 바인딩 하기
        	ppsm = con.prepareStatement("select * from choanbiota where upper(specific_name) like ?");
        	ppsm.setString(1,  "%" + specific_name + "%"); // SQL 실행하기
        	rs = ppsm.executeQuery();
        	
        	// 데이터를 읽어서 list 에 저장하기
        	while(rs.next()) { // 하나의 행을 읽어서 DTO 에 저장
        		Choanbiota choanbiota  = new Choanbiota();
        		choanbiota.setNum(rs.getInt("num"));
        		choanbiota.setPopulation(rs.getInt("population"));
        		choanbiota.setSpecific_name(rs.getString("specific_name"));
        		choanbiota.setDetect_day(rs.getDate("detect_day"));
        		
        		list.add(choanbiota); // 읽은 데이터를 리스트에 저장
        	}
        	
        	
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        
        
        close();
		return list;
	}
	

}
