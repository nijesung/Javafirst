package api;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class setMain {

	public static void main(String[] args) {
	//	HashSet<String> insect = new HashSet<>();
		TreeSet<String> insect = new TreeSet<>();
	//	LinkedHashSet<String> insect = new LinkedHashSet<>(); // 저장한 순서대로 출력
		insect.add("길앞잡이");
		insect.add("모기");
		insect.add("중국매미");
		insect.add("장수잠자리");
		insect.add("길앞잡이");
		insect.add("폭탄먼지벌레");
		
		for(String s : insect) {
			System.out.println(s);
		}

	}

}
