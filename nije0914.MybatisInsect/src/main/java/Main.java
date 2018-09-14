import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.InsectDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InsectDao dao = context.getBean(InsectDao.class);
		System.out.println(dao);
		
		context.close();

	}

}
