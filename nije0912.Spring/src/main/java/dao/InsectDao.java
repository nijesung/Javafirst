package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.InsectVO;

  public class InsectDao {
	public InsectDao() {}
	
	// InsectDao(){}
	
	// 전체 데이터를 가져오는 메소드
	// 파라미터를 만들 때는 insert 나 update 는 VO
	// delete 는 primary key
	// select 는 where 절에 대입되어야 하는 데이터
	// select * from Insect
	public List<InsectVO> getInsect(){
		// List 를 리턴할 때는 객체를 생성하고 리턴하도록 작성
		// 조회할 때는 ArrayList 가 좋다.
		List<InsectVO> list = new ArrayList<InsectVO>();
		
		Connection con = null;
		PreparedStatement ppsm = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user11", "user11");
			ppsm = con.prepareStatement("select * from insect");
			rs = ppsm.executeQuery();
			while(rs.next()) {
				InsectVO vo = new InsectVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setDescription(rs.getString("description"));
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(con != null)con.close();
				if(ppsm != null)ppsm.close();
				if(rs != null)rs.close();
			}catch(Exception e) {}
		}	
				
		
		
		return list;
	}

}
