import org.springframework.context.support.GenericXmlApplicationContext;

import vo.CollectionBean;
import vo.Sample;

public class Main {

	public static void main(String[] args) {
		// 스프링 컨테이너 실행하기 - 컨테이너 안에 있는 bean 의 객체가 전부 생성된다.
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 생성된 객체 가져오기
		// 아이디만 대입한 경우는 Object 만 리턴되므로 강제 형 변환해서 사용해야 한다.
		// 동일한 클래스로 만들어진 bean 이 1개이면 아이디를 생략하고 클래스 이름만 대입해도 된다.
		Sample sample = context.getBean("sample", Sample.class);
		System.out.println(sample);
		
		// Collection 객체 가져오기
		CollectionBean collectionBean = context.getBean(CollectionBean.class);
		for(String imsi : collectionBean.getSet()) {
			System.out.println(imsi);
		}
		
		context.close();
	}

}
