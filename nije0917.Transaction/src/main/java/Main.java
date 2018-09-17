import org.springframework.context.support.GenericXmlApplicationContext;

import service.DeptService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		DeptService deptService = context.getBean(DeptService.class);
		deptService.insertdept();
		
		context.close();
	}

}
