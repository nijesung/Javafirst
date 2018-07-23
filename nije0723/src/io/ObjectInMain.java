package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInMain {

	public static void main(String[] args) {
		// 객체 단위로 데이터를 기록할 수 있는 클래스의 변수선언
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream( // 파일에 객체 단위로 기록할 수 있는 클래스의 객체 만들기
			new FileInputStream("C:\\Users\\503-11\\Desktop\\test\\oos.txt"));
			
			Member member = (Member)ois.readObject(); // read 로 읽어올 때 Object 타입으로 리턴하기 때문에
			                                          // 강제 형 변환을 해서 원래의 자료형으로 되돌려서 사용해야 한다.
			System.out.println(member);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(ois !=null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
