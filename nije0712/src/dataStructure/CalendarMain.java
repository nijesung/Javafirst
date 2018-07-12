package dataStructure;

import java.sql.Date;
import java.util.Calendar;

public class CalendarMain {

	public static void main(String[] args) {
		
		Calendar oldDay = Calendar.getInstance(); // 1990 년 11월 22일을 calendar 객체로 만들기
		oldDay.set(Calendar.YEAR, 1990);
		oldDay.set(Calendar.MONTH, 11);
		oldDay.set(Calendar.DAY_OF_MONTH, 22);
		
		Date date = new Date(oldDay.getTimeInMillis());
		
		Calendar toDay = Calendar.getInstance();
		long gap = toDay.getTimeInMillis() - oldDay.getTimeInMillis();
		System.out.println("당신은 태어난 지 " + (gap/24/60/60/1000) + "일 째 되는 날 입니다.");
		
	}

}
