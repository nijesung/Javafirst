package Constructor;

public class Practice {
	
	static {
	 System.out.println("맨 처음에만 수행됨"); // 가장 처음에 한 번만 수행
	}
	
	{
	System.out.println("인스턴스 만들 때 마다 수행됨"); // new 나올 때 마다 수행됨
	}
	
	
	
	// 생성자
	public Practice() {
		name = "noname";
	}
	// 생성자2
	public Practice(String arg) { // 생성자 오버로딩 (동일한 이름의 메소드가 2개 있는 경우)
		name = arg;
	}
	
	

	private String name; // 이름을 저장하기 위한 인스턴스 변수를 선언

	public String getName() { // name 의 접근자 메소드
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public void display() {
		String name = "지역변수 name";
	    System.out.println(name);
		System.out.println(this.name); // this. 를 붙이면 지역변수에서는 찾지 않고 인스턴스 변수에서 찾는다.
		
	}
	
	
	
	
}

