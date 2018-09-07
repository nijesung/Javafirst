/*
package test;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.UserDaoImplImpl;
import vo.Fighter;

public class Main {
	
	@Test
	public void main() {
		UserDao userDao = UserDaoImplImpl.sharedInstance();
		Fighter fighter = new Fighter();
		fighter.setEmail("rombard@gmail.com");
		fighter.setPw("123123");
		fighter.setName("헥터 롬바드");
		fighter.setPhone("01088887777");
		fighter.setAddr("데스밸리");
		boolean r = userDao.registerFighter(fighter);
		System.out.println(r);
	}

}
*/
package test;



import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.UserDaoImplImpl;

public class Main {
	@Test
	public static void main(String[] args) {
		
		UserDao userDao = UserDaoImplImpl.sharedInstance();
		System.out.println(userDao.emailCheck("adesanya@gmail.com"));

	}

}
