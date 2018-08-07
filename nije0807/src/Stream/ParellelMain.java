package Stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParellelMain {
	
	// 1초 대기하는 메소드
	public static void work(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int [] ar = {18, 28, 38, 48, 58, 68, 78, 88, 98};
		
		// 일반 스트림으로 work 작업을 수행
		IntStream stream = Arrays.stream(ar);
		// 작업 시간 측정
		long start = System.currentTimeMillis(); 
		stream.forEach(su -> work(su));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		// 병렬 스트림으로 work 작업을 수행
		stream = Arrays.stream(ar);
		start = System.currentTimeMillis(); 
		stream.parallel().forEach(su -> work(su));
        end = System.currentTimeMillis();
        System.out.println(end - start);

	}

}
