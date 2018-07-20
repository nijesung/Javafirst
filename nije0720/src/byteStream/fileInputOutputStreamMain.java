package byteStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileInputOutputStreamMain {

	public static void main(String[] args) {
		
		// try & catch & finally 는 각각의 블럭
		// 변수는 블럭 밖으로 떠내 선언한다
		FileOutputStream fos = null; // 파일에 바이트 단위로 기록할 수 있는 스트림 변수 생성
		
		try { // 예외가 발생할 가능성이 있는 구문을
			fos = new FileOutputStream("C:\\Users\\503-11\\Desktop\\test\\insect.txt", true);
			// true 를 주면 이어서 쓸 수 있다
			
		//	fos.write(200); // 파일에 1바이트 기록
			
		 //	byte [] ar = {33, 34, 35, 36, 37};
		 //	fos.write(ar);
			String str = "insect";
			fos.write(str.getBytes());
			
			fos.flush(); // 버퍼의 내용을 비움
		}
		catch(Exception e) { // 예외가 발생했을 때 수행할 구문
			System.out.println("파일 입출력 예외: " + e.getMessage());
			
			// 현재 날짜와 시간 그리고 예외 내용을 로깅한다
			// 파일에 기록하거나 네트워크를 통해서 서버에 전달한다
			
		}
		finally { // 예외 발생 여부에 상관없이 수행할 구문
			
			// 이곳에서 close 한다
			try {
				if(fos != null) // 경고가 생기기 때문에 처리를 해 준 것
				fos.close();
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}

		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\503-11\\Desktop\\test\\insect.txt");
			/*
			int r = fis.read(); // 1 바이트 읽어오기
			System.out.println((char)r); // 문자로 출력하고 싶으면 캐릭터로 형 변환
			*/
			/*
			byte [] by = new byte[4]; // 4 바이트 읽어오기
			fis.read(by);
			System.out.println(by);
			*/
			
			// 4 바이트 씩 전체를 읽기
			// read 에 바이트 배열을 대입하면 읽은 갯수를 리턴
			// 0보다 작거나 같은 값을 리턴하면 읽을 데이터가 없다는 뜻이다
			
			while(true) {
				byte [] by = new byte[100]; // 배열은 toString 이 재정의 되어 있지 않아서 해시코드가 출력된다
				int r = fis.read(by);
			 //	System.out.println(by);
				/*
			    for(byte imsi : by) { // 코드를 각각 출력
			    	System.out.println(imsi);
			    }
			    */
				System.out.println(new String(by)); // 문자열로 변환해서 출력
				
				if(r <= 0) {
					break;
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("flie reader exception: " + e.getMessage());
		}
		finally {
			if(fis != null) {
				try {
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}
}
