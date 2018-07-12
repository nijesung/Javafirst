package dataStructure;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class formatMain {

	public static void main(String[] args) {
		Date date = new Date();
		int money = 5555000;
		
		// 0000년 00월 00일 요일 00시 00분 00초 형식으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 EEE a hh시 mm분 ss초");
		String msg = sdf.format(date);
		System.out.println(msg);
		
		// \5,555,000 형식으로 출력
		DecimalFormat df = new DecimalFormat("\u00a4 #,##0");
		msg = df.format(money);
		System.out.println(msg);
		
		
		
		
		

	}

}
