import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.InsectDao;
import com.mybatis.domain.Insect;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InsectDao dao = context.getBean(InsectDao.class);
		List<Insect> list = dao.list();
		for(Insect insect : list) {
			System.out.println(insect);
		}
		
		context.close();
		

	}

}
