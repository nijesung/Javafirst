package api;

import java.nio.file.WatchEvent.Kind;
import java.util.*;

public class listmain<kind> {
	
	public static void main(String[] args) {
	
	ArrayList<insect> list = new ArrayList<>();
	
	insect insect = new insect();
	insect.setKind("길앞잡이");
	insect.setVolume(15);
	list.add(insect);
	
	insect = new insect();
	insect.setKind("소금쟁이");
	insect.setVolume(25);
	list.add(insect);
	
	// 리스트의 모든 데이터를 확인만 하고 싶을 때
	System.out.println(list);
	
	Comparator<insect> comp = new Comparator() {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	list.sort(comp);
	
	// 각각의 데이터 확인
	for(insect temp : list) {
		System.out.println(temp);
	}
	
	
	
	
	}
}
	
	

	

