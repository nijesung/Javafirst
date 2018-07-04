package polymorphism02;

public class Main {

	public static void main(String[] args) {
		// 3개 kind의 날아오르는 메소드 호출해보기
		
		
		biology bio = new biology();
		
	 //	bug bug = new bug(); 
		bio = new bug();
        bio.fly(); // 하나의 변수를 가지고 3개의 인스턴스를 전부 대입받을 수는 있지만 메소드 호출은 안 된다
		           // 변수는 오버라이딩된 메소드만 하위 클래스의 것을 호출할 수 있기 때문이다.
		           // 오버라이딩을 만들어주기 위해서 biology 클래스에 fly() 를 추가해야 한다
		
	 //	bird bird = new bird(); 
	 // bird.glide(); // 유사한 역할을 수행하는 메소드들의 이름은 서로 동일한 것이 좋다.
        bio = new bird();
        bio.fly();
		
	 //	fungi fungi = new fungi();
        bio = new fungi();
        bio.fly();
		
		// bug 와 bird 와 fungi 클래스 들 간에 아무런 관계도 없어 세 개의 변수를 만들어서 메소드를 호출한 상황이다.
		// 상위 클래스 타입의 변수에 하위 클래스 타입의 인스턴스 주소를 대입할 수 있는 문법을 이용하면 하나의 변수에 3개 클래스의
		// 인스턴스 주소를 대입할 수 있습니다.
        
        // 이런 식으로 만들면 Main 을 제외한 클래스들이 복잡해지지만 Main 클래스는 간결해진다.
        // Main 클래스는 유저가 사용하는 클래스이고 나머지 클래스는 보조적인 역할을 수행하는 클래스이다.
        // Main 이 간결해지면 클라이언트는 편리해지고 개발자는 피곤해진다.
		
		
		
	}

}
