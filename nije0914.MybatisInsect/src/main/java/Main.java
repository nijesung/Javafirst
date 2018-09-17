import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.mybatis.dao.InsectDao;
import com.mybatis.domain.Insect;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		InsectDao dao = context.getBean(InsectDao.class);
		
		Insect ins = new Insect();
		ins.setCode(100);
		ins.setName("kingbug");
		ins.setPrice(50000);
		ins.setDescription("anywhere");
		dao.insertInsect(ins);
		
		List<Insect> list = dao.list();
		for(Insect insect : list) {
			System.out.println(insect);
		}
		
		context.close();
		

	}

}
