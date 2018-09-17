import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.UfcDao;
import com.pk.mybatis.domain.UfcVO;

public class Main {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
			
			UfcDao dao = context.getBean(UfcDao.class);
			
			/*
			List<UfcVO> list = dao.ufclist();
			for(UfcVO vo : list) {
				System.out.println(vo);
			}
			*/
			
			// id 를 가지고 데이터를 조회하는 메소드 호출
			/*
			UfcVO vo = dao.selectufc("bolkan");
			System.out.println(vo);
			
			vo = dao.selectufc("hendricks");
			System.out.println(vo);
			*/
			Scanner sc = new Scanner(System.in);
			// primary key 의 값을 입력받는 경우에는 반드시 중복 체크를 해야 한다.
			String id = "";
			while(true) {
				System.out.println("사용할 id 를 입력하시오: ");
				id = sc.nextLine();
				UfcVO vo = dao.selectufc(id);
				if(vo == null) {
					break;
				}
				System.out.println(id + " 는 사용 불가능한 id 이다.");
			}
			
			System.out.println("비밀번호 입력: ");
		    String pw = sc.nextLine();
		    
		    System.out.println("이름 입력: ");
		    String name = sc.nextLine();
		    
		    System.out.println("폰번호 입력: ");
		    String phone = sc.nextLine();
		    
		    UfcVO nvo = new UfcVO();
		    nvo.setId(id);
		    nvo.setPw(pw);
		    nvo.setName(name);
		    nvo.setPhone(phone);
		    
		    // select 이외의 구문은 영향받은 행의 개수를 리턴
		    // int result = dao.insertufc(nvo);
		    int result = dao.insertprocedure(nvo);
		    
		    System.out.println(result);
			
			sc.close();
			context.close();
			

		}

	}
