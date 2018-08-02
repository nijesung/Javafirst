package DB;

import java.util.List;

public interface ChoanbiotaDao {
	
	public boolean insertChoanbiota(Choanbiota choanbiota); // 데이터를 삽입하는 메소드
	
	public boolean updateChoanbiota (Choanbiota choanbiota); // 데이터를 수정하는 메소드
	
	public boolean deleteChoanbiota (int num); // 데이터를 삭제하는 메소드
	
	public List<Choanbiota> allChoanbiota();// 데이터 전체를 읽어오는 메소드
	                                        // 데이터가 0개 이상이므로 List 로 리턴하고 읽어올 컬럼들을 저장할 DTO 클래스나 Map 으로 
	                                        // 제너릭을 적용하면 된다.     
	
	public List<Choanbiota> specific_nameChoanbiota(String specific_name);

	
}
