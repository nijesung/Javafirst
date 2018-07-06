package object;

public class insect {
	
     private String kind; // 종, 크기, 악력 을 저장할 변수
     private int volume;
     private int grip;
     
     
	public String getKind() { // 인스턴스 변수를 사용하기 위한 접근자 메소드 - getters & setters
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	@Override // 내부 데이터의 값을 빠르게 확인하기 위한 용도로 사용
	public String toString() {
		return "insect [kind=" + kind + ", volume=" + volume + ", grip=" + grip + "]";
	}
	public int getGrip() {
		return grip;
	}
	public void setGrip(int grip) {
		this.grip = grip;
	}
	
	// 2개의 내용이 같은지 비교하는 메소드
	public boolean equals(insect ohter) { // 호출하는 인스턴스의 kind 와 매개변수의 kind 가 같으면
		boolean result = false;           // true 를 리턴하고 그렇지 않으면 false 를 리턴
		if(kind.equals(ohter.kind)) {
			result = true;
		}
		return result;
	}
	
}
