package mutex;

public class mutexMain01 {

	public static void main(String[] args) {
		mutex01 mutex = new mutex01();
        Thread th01 = new Thread(mutex);
        th01.start();
        Thread th02 = new Thread(mutex); // 실행할 때 마다 값이 다르게 나온다 (일반적인 논리적 오류는 아니다)
        th02.start();
        
        try {
			Thread.sleep(25000); // 25초 후에 mutex의 result 값 확인
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(mutex.getResult());
	}

}
