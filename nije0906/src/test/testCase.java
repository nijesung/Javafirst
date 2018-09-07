package test;



import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.UserDaoImplImpl;

public class testCase {
	@Test
	public static void main(String[] args) {
		
		UserDao userDao = UserDaoImplImpl.sharedInstance();
		System.out.println(userDao.emailCheck("adesanya@gmail.com"));

	}

}
