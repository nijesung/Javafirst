package main;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.InsectDao;
import dao.InsectDaoFactory;
import vo.InsectVO;

public class Main {

	public static void main(String[] args) {
		// InsectDao 인스턴스를 생성
		// InsectDao dao = new InsectDao();	에서 아래의 문장으로 바뀐다.
		// InsectDao dao = InsectDaoFactory.create();
		
		// 스프링을 이용해서 객체를 생성 - 싱글톤 패턴이 자동으로 적용
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InsectDaoFactory.class);
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// InsectDao dao = context.getBean("create", InsectDao.class);
		InsectDao dao = context.getBean("insectDao", InsectDao.class);
		
		System.out.println(dao.hashCode());
		
		// 필요한 메소드 호출
		List<InsectVO> list = dao.getInsect();
		// 메소드 호출 결과 출력
		for(InsectVO vo : list) {
			System.out.println(vo);
		}

		// dao = InsectDaoFactory.create();
		// dao = context.getBean("create", InsectDao.class);
		dao = context.getBean("insectDao", InsectDao.class);
		System.out.println(dao.hashCode());
		context.close();

	}

}
