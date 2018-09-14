package com.mybatis.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

// 객체를 자동으로 생성해 주는 어노테이션
@Repository
public class InsectDao {
	// 동일한 자료형의 bean 이 있으면 자동으로 대입해 주는 어노테이션
	@Inject
	private SqlSession sqlSession;

}
