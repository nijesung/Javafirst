package com.mybatis.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mybatis.domain.Insect;

// 객체를 자동으로 생성해 주는 어노테이션
@Repository
public class InsectDao {
	// 동일한 자료형의 bean 이 있으면 자동으로 대입해 주는 어노테이션
	@Inject
	private SqlSession sqlSession;
	
	// 테이블의 전체 데이터를 가져오는 메소드
	public List<Insect> list(){
      return sqlSession.selectList("insect.list");
    }
	
	// 테이블에 데이터를 삽입하는 메소드
	public int insertInsect(Insect insect) {
		return sqlSession.insert("insect.insertinsect",insect);
	}

}
