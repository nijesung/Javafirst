package Stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.fetch();
		/*
	 //	System.out.println(list);
		for(StudentVO vo : list) {
			// 출력하는 메소드에 인스턴스 이름을 대입하면 toString 의 결과
			System.out.println(vo);
		}
		*/
		
		// Stream 생성
		Stream<StudentVO> stream = list.stream();
		
		// 데이터를 전부 출력
		// forEach 앞에다 필요한 것을 넣을 수 있다
	 //	stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		
		// 남자인 데이터만 출력
		/*
		stream.filter(data -> data.getGender().equals("남성")).forEach(data -> 
		System.out.println(data));
		*/
		
		// 데이터 정렬하기 - score
		/*
		stream.sorted((d1, d2) -> d2.getName().compareTo(d1.getName()))
				.forEach(data -> System.out.println(data));
				*/
		
		// 데이터의 개수를 long 타입으로 반환
		/*
		long cnt = stream.count();
		System.out.println(cnt);
		*/
		
	 //	Optional<StudentVO> vo = stream.findFirst();
		// Optional 로 리턴되는 데이터는 한번 더 가공을 해야 한다.
		/*
		StudentVO vo = stream.findFirst().get();
		System.out.println(vo);
		*/
		
		// score 의 합계 구하기
		// 숫자 데이터가 아니면 바로 합계를 구할 수 없기 때문에 map 메소드를 이용해서 숫자 데이터로 변경한 후 합계를 구해야 한다.
		/*
		int sum = stream.mapToInt(StudentVO::getScore).sum();
		System.out.println("합계: " + sum);
		*/
		
		// age 의 평균 구하기
		/*
		double age = stream.mapToInt(StudentVO::getAge).average().getAsDouble();
		System.out.println("나이 평균: " + age);
		*/
		
		// 성별이 양성인 데이터의 평균 점수를 구하는데 소수 1째 자리에서 반올림해서 정수 부분만 출력
		/*
		double avg = stream.filter(data -> data.getGender().equals("양성"))
				.mapToInt(StudentVO::getScore).average().getAsDouble();
		int score = (int)(avg + 0.5);
		System.out.println("양성 평균 점수: " + score);
		*/
		
		// 성별이 여자인 데이터만 가지고 List 를 생성
		/*
		List<StudentVO>result = stream.filter(data -> data.getGender().equals("여자"))
				.collect(Collectors.toList());
		for(StudentVO vo : result) {
		System.out.println(vo);
		}
		*/
		
		// 이름과 점수만을 갖는 Map 으로 생성
		/*
		Map<String, Integer>map =
		stream.collect(Collectors.toMap(StudentVO::getName, StudentVO::getScore));
		System.out.println(map);
		*/
		
		// 위와 다르게 람다를 이용해도 된다
		/*
		Map<String, Integer>map =
				stream.collect(Collectors.toMap(StudentVO::getName, data -> data.getScore()));
				System.out.println(map);
				*/
		
		// 성별이 남자이고 score 가 50 이상인 데이터의 List 를 생성해서 출력
		/*
		List<StudentVO>result = stream.filter(data -> data.getGender().equals("남성")
				&& data.getScore() >= 50)
				.collect(Collectors.toList());
		for(StudentVO vo : result) {
		System.out.println(vo);
		}
		*/
		
		// groupingBy 에 작성한 함수의 결과를 key 로 하고 원래 데이터의 List 를 값으로 해서 
		// Map 으로 리턴한다.
		/*
		Map<String,List<StudentVO>> map 
		= stream.collect(Collectors.groupingBy(StudentVO::getGender));
		System.out.println(map);
		*/
		
		// gender 별로 score 의 합계를 정수로 출력 
		Map<String, Integer> map =
		stream.collect(Collectors.groupingBy(StudentVO::getGender, Collectors
				.summingInt(StudentVO::getScore)));;
				System.out.println(map);
				
				
		// Map 의 데이터 전부 출력하기 (키를 알지 못해도 데이터를 전부 출력할 수 있다는 점이 맵의 강점이다)
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key + ":" + map.get(key));
		}
		

	}

}
