package DB;

import java.sql.Date;
import java.util.Calendar;

public class ChoanbiotaMain {

	public static void main(String[] args) {
		ChoanbiotaDao dao = new ChoanbiotaDaoImpl(); // 하위 클래스의 인스턴스를 생성해서 대입한다
		Choanbiota choanbiota = new Choanbiota();
		choanbiota.setNum(1);
		choanbiota.setPopulation(50);
		choanbiota.setSpecific_name("길앞잡이");
		
		Calendar cal = Calendar.getInstance(); // 현재 시간을 저장한 캘린더 생성
		cal.set(Calendar. YEAR, 2018);
		cal.set(Calendar. MONTH, 8);
		cal.set(Calendar. DAY_OF_MONTH, 2);
		Date detect_day = new Date(cal.getTimeInMillis());
		choanbiota.setDetect_day(detect_day);
		
		
		boolean r = dao.updateChoanbiota(choanbiota); // 업데이트 하기
		if(r == true) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
			System.out.println("예외를 확인");
		}
		
		
		boolean r2 = dao.deleteChoanbiota(1); // 삭제 하기
		if(r2 == true) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
			System.out.println("예외를 확인");
		}
		
		

	}

}
