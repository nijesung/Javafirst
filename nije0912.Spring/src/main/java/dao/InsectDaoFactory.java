package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsectDaoFactory {
	@Bean
	// InsectDao 인스턴스를 생성해서 리턴하는 메소드
	public static InsectDao create() {
		return new InsectDao();
	}
}
