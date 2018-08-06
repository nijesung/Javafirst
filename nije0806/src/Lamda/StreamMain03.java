package Lamda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain03 {

	public static void main(String[] args) {
		/*
		Student stud = new Student();
		stud.setName("추키야마");
		stud.setGender("남자");
		stud.setAge(18);
		stud.setScore(28);
		stud.setSubject("두개의심장열매능력자");
		*/
		
	 //	Student stud2 = new Student("존존스", "남자", 88, 30, "눈알적출학과");
		
		// Student 클래스의 인스턴스의 배열
		Student [] ar = new Student[5]; // 배열은 처음 만들면 참조형은 모두  null 이 들어가 있다
	 //	ar[0].getAge(); // java.lang.NullPointerException 에러 발생 . 앞에 있는 것이 널이다
		ar[0] = new Student("존존스", "남자", 88, 100, "눈알적출학과 종신교수");
		ar[1] = new Student("추키야마", "여자", 18, 28, "두개의심장열매능력자");
		ar[2] = new Student("최두호", "남자", 91, 50, "리듬학과 수강생");
		ar[3] = new Student("음장", "여자", 90, 1, "자동화 학과 수강생");
		ar[4] = new Student("김민재", "남자", 91, 50, "리듬학과 수강생");
		
		// 성별이 남자인 데이터만 출력
		/*
		Stream <Student> stream = Arrays.stream(ar);
		stream.filter(student -> student.getGender().equals("남자")).
		forEach(student -> System.out.println(student));
		*/
		
		// 성별이 여자이고 나이가 20 이상인 데이터
		/*
		Stream <Student> stream = Arrays.stream(ar);
		stream.filter(student -> student.getGender().equals("여자")
				&& student.getAge() >= 20).
		forEach(student -> System.out.println(student));
		*/
		
		// Student 를 score 로 변경
		// map 은 바꿀 때 사용
		/*
		Stream <Student> stream = Arrays.stream(ar);
		stream.mapToInt(Student::getScore).
		forEach(student -> System.out.println(student));
		*/
		
		int [] array = {30, 20, 31, 78, 12};
		IntStream stream = Arrays.stream(array);
		stream.sorted().forEach(su -> System.out.println(su));
		
		String [] roach = {"먹바퀴", "이질바퀴", "대왕바퀴", "넥센타이어"};
		// 문자열 배열을 정렬해서 출력
		Stream<String> s = Arrays.stream(roach);
	 //	s.sorted().forEach(su -> System.out.println(su));
		// 내림차순 정렬
		s.sorted((n1, n2)-> n2.compareTo(n1)).forEach(su -> System.out.println(su));

	}

}
