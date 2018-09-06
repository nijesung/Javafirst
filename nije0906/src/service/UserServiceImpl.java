package service;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import dao.UserDaoImplImpl;
import vo.Fighter;

public class UserServiceImpl implements UserService {
		// 외부에서 인스턴스 생성을 못 하도록 생성자를 private 으로 설정
	
	private UserDao userDao;
	private UserServiceImpl() {
		userDao = UserDaoImplImpl.sharedInstance();
	}
		
		// 인스턴스 1개의 주소를 저장할 수 있는 변수를 생성(static 을 붙인 이유)
		private static UserService userService;
		
		// 외부에서 인스턴스를 사용할 수 있도록 pubilc 으로
		// 인스턴스의 주소를 리턴 해 주는 메소드
		public static UserService sharedInstance() {
			// 처음 한 번만 인스턴스를 생성하도록 해 주는 코드
			if(userService == null) {
				userService = new UserServiceImpl();
			}
			return userService;
		}

		@Override
		public Fighter login(HttpServletRequest request) {
			// 파라미터 전부 읽기
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			
			// 내가 입력한 이메일과 패스워드가 출력 되는지 확인
			// 이 메시지가 출력되지 않으면 Controller 의 URL 을 확인한 후
			// 메소드 이름을 확인해야 한다.
			// 파라미터가 잘못 나오는 경우는 jsp 파일의 name 과
			// getParameter 의 이름을 확인
			System.out.println("email: " + email);
			System.out.println("pw: " + pw);
			
			// 수행할 연산이 있으면 연산을 수행
			
			// 호출할 Dao 메소드의 매개변수를 생성
			Fighter fighter = new Fighter();
			fighter.setEmail(email);
			fighter.setPw(pw);
			
			// Dao 메소드 호출
			Fighter user = userDao.login(fighter); //?
			
			// 결과 리턴
			return user;
		}
	

}
