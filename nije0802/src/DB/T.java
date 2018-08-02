package DB;

public class T {

	private T(){} // 외부에서 객체를 생성하지 못하도록 생성자를 private 으로 변경
	
	private static T obj; // 1개만 만들어 리턴해주기 위한 static 변수 선언
	
	public static T getInstance() { // 객체가 없으면 만들어서 리턴하고 있으면 그냥 리턴하는 static 메소드를 생성
		if(obj == null) {
			obj = new T();
		}
		return obj;
	}
}
