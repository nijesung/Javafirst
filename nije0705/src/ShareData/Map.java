package ShareData;

public class Map { 
	private double latitude;
	private double longitude;
	
	
	// 매개변수가 없는 생성자 - default constructor
    public Map() {
		super();
	}
    
    
    // 접근자 메소드 - getter & setter
    public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
    

	
	// 매개변수가 있는 생성자
	public Map(double latitude, double longitude) { // Source 메뉴에서 자동으로 만들어 준다
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	
	public void showMap() {  // 지도를 출력하는 메소드
		System.out.println("위도:" + latitude + "경도:" + longitude + "위치의 지도를 출력합니다.");
	}
	

}
