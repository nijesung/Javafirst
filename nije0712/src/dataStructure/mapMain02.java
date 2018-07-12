package dataStructure;

public class mapMain02 {

	public static void main(String[] args) {
		// 계통분류 명단을 배열로 만들기
		String[]Insect = {"길앞잡이","나방","파리","사슴벌레"};
		String[]Arthropoda  = {"지네","거미","노래기"};
		String[]Newts = {"게코","개구리","올름"};
		String[]Collembola = {"톡토기"}; // 계통을 추가하자 출력하는 부분에서도 추가해줘야 한다. 즉 유지보수에 불리
		
		String [][] line = {Insect, Arthropoda, Newts, Collembola}; // String 배열의 배열 만들기
		
		// 이차원 배열의 데이터 출력
		for(int i = 0; i < line.length; i = i+1) { // 큰 배열에 포함된 작은 배열의 데이터 갯수만큼 반복한다
			if(i==0) {
				System.out.print("Insect: " + "\t"); // 계통 데이터 출력
			}else if(i==1) {
				System.out.print("Arthropoda: " + "\t");
			}else if(i==2) {
				System.out.print("Newts: " + "\t");
			}else {
				System.out.print("Collembola: " + "\t");
			}
			
			String [] in = line[i]; // 작은 배열을 순서대로 가져온다
			for(int j = 0; j<in.length; j=j+1) { // 작은 배열의 데이터 갯수만큼 반복
				System.out.print(in[j] + "\t");
			}
			System.out.println("");
		}
		
		
		

	}

}
