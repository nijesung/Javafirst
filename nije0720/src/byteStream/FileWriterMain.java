package byteStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {

	public static void main(String[] args) {
		FileWriter fw = null;
		FileReader fr = null;
		try {
		    //	fw = new FileWriter("C:\\Users\\503-11\\Desktop\\test\\insect.txt");
			/*
			fw.write("halo"); // 줄바꿈이 되지 않는다
			fw.write("halow");
			fw.write("hale");
			fw.flush();
			*/
			fr = new FileReader("C:\\Users\\503-11\\Desktop\\test\\insect.txt");
			char [] buf = new char[10]; // 배열을 밖에서 만들었을 때는 갯수 만큼만 사용을 해야 한다
			// fw.read(buf);
		 //	System.out.println(new String(buf));
			while(true) { // buf 의 크기만큼 읽어서 buf 에 저장하고 읽은 갯수를 r에 저장
				int r = fr.read(buf);
				if(r <= 0) {
					break;
				}
				System.out.println(new String(buf, 0, r)); // 배열에서 0번째 부터 r 만큼만 문자열로 변환해서 출력
			}
			
			
		}
		catch(Exception e) {
			System.out.println("record exception: " + e.getMessage());
		}
		finally {
			if(fw != null);
			try {
			 //	fw.close();
				fr.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	}
}
