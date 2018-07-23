package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) {
		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수선언
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream( // 파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
			new FileOutputStream("C:\\Users\\503-11\\Desktop\\test\\oos.txt"));
			
			Member member = new Member();
			member.setEmail("insect@gmail.com");
			member.setPw("123123");
			member.setPhone("01026665626");
			
			
			oos.writeObject(member); // 객체를 파일에 기록
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(oos !=null)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
