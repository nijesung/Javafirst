package dataStructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class lottoMain {

	public static void main(String[] args) {
		// 1 부터 45까지의 숫자 6개를 랜덤하게 저장해서 출력
		// 랜덤한 숫자를 얻기 위해 랜덤 인스턴스를 생성
		
		int i, j;
		
		Random r = new Random(); // 중복  문제가 생긴다
		int [] lotto = new int[6];
		for(i =0; i<6; i=i+1) {
			lotto[i] = r.nextInt(45)+1;
			for(j=0; j<i-1; j=j+1) {
				if(lotto[i] == lotto[j]) {
					break;
				}
			}
			
			if(i != j) {
				i = i-1;
			}
		}
		Arrays.sort(lotto);
		for(int x : lotto) {
			System.out.println(x);
		}

	}

}
