import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.UfcInterface;
import com.pk.mybatis.domain.UfcVO;



public class InterfaceMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 매퍼 인터페이스를 구현한 객체 찾아오기
	
		UfcInterface ufcInterface = context.getBean(UfcInterface.class);
		/*
		List<UfcVO> list = ufcInterface.listufc();
		for(UfcVO vo : list) {
			System.out.println(vo);
		}
		*/
		
		
		UfcVO vo = ufcInterface.selectufc("bolkan");
		System.out.println(vo);
		
		
		context.close();
	}

}
