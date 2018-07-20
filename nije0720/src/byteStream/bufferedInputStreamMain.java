package byteStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class bufferedInputStreamMain {

	public static void main(String[] args) {
		// 파일에서 바이트 단위로 버퍼링을 이용해서 읽기
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("C:\\Users\\503-11\\Desktop\\test\\insect.txt"));
			
			while (true) {
				byte[] by = new byte[1024];
				int r = bis.read(by);
				/*
				 * for(byte temp : b) { System.out.println(temp); }
				 */
				System.out.println(new String(by));
				if (r <= 0) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		} finally {
			try {
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		
		
	}
}
