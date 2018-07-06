package object;

public class Main {

	public static void main(String[] args) {
		// insect 클래스의 인스턴스를 생성해서 데이터를 저장
		insect insect1 = new insect();
		insect1.setKind("길앞잡이");
		insect1.setVolume(100);
		insect1.setGrip(50);
		
	 //	System.out.println(insect1.toString()); // toString 을 호출해서 출력
	 //	System.out.println(insect1); // toString 메소드 만은 인스턴스 이름을 기재한 경우 자동으로 호출.
		
		insect insect2 = new insect();
		insect2.setKind("길앞잡이");
		insect2.setVolume(150);
		insect2.setGrip(75);
		
		System.out.println(insect1 == insect2);
		System.out.println(insect1.equals (insect2));


	}

}
