package test;

import java.util.Scanner; // Scanner 클래스는 패키지 이름을 생략하고 사용할 수 있도록 해준다.

import java.util.Date;

import java.util.*; // java.util 패키지의 모든 클래스는 패키지 이름을 생략하고 사용할 수 있도록 해준다. 

import java.sql.*; // Date 클래스는 java.util 패키지에도 있고 java.sql 패키지에도 존재한다.
                          // 이렇게 여러 패키지에 존재하는 클래스의 경우에는 반드시 구체적으로 import를 지정해 줘야 한다.

public class Scanner01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	 // Date date = new Date(); // 오류가 나는 것은 구체적으로 지정해 주지 않았기 때문이다.
		
		sc.close();
		

	}

}
