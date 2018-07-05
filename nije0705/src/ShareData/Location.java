package ShareData;

public class Location { // 위치 정보를 가져오는 클래스
	public double latitude;
	public double longitude;
	
	public void getLocation() { 
		
		
	 //	Map map = new Map(latitude, longitude); // 생성자를 이용한 데이터 전달
	 //	map.showMap();
		
		Map map = new Map(); // setter 를 이용한 데이터 전달
		map.setLatitude(latitude);
		map.setLongitude(longitude);
		
		map.showMap();
		
	}
}
