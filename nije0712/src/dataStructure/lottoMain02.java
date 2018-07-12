package dataStructure;

import java.util.Random;
import java.util.TreeSet;

public class lottoMain02 {

	public static void main(String[] args) {
		
		Random r = new Random();
		TreeSet<Integer> lotto = new TreeSet<>();
		while(lotto.size() < 6) {
			lotto.add(r.nextInt(45) + 1);
		}
		for(int x : lotto) {
			System.out.println(x);
		}

	}

}
