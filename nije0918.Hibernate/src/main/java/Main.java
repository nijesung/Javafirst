import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.dao.FruitDao;
import com.pk.domain.Fruit;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		FruitDao dao = context.getBean(FruitDao.class);
		Fruit fru = new Fruit();
		fru.setCode(7);
		fru.setName("순무");
		fru.setManufacture("노라드");
		fru.setPrice(1500);
		
		// dao.insertFruit(fru);
		// dao.updateFruit(fru);
		dao.deleteFruit(fru);
		
		// 전체 데이터 가져오기
		List<Fruit> list = dao.list();
		for(Fruit fruit : list) {
			System.out.println(fruit);
		}
		
		// 데이터 1개 가져오기
		System.out.println("========================");
		System.out.println(dao.get(7));
		System.out.println(dao.get(8));
		
		
		context.close();
	}

}
