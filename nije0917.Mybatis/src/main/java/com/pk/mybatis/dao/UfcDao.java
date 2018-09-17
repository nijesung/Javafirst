package com.pk.mybatis.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pk.mybatis.domain.UfcVO;

//객체를 자동으로 생성해 주는 어노테이션
@Repository
public class UfcDao {
	
	// 동일한 자료형의 bean 이 있으면 자동으로 대입해 주는 어노테이션
		@Inject
		private SqlSession sqlSession;
		
		// Ufc 테이블의 전체 데이터를 가져오는 메소드
		public List<UfcVO> ufclist(){
	      return sqlSession.selectList("ufc.ufclist");
	    }
		
		// Ufc 테이블에서 id 를 가지고 하나의 데이터를 찾아오는 메소드
	    public UfcVO selectufc(String id) {
	    	// 하나를 찾아오는 메소드 호출
	    	// 없으면 null 을 리턴하고 2개 이상이면 예외를 발생시킨다.
	    	return sqlSession.selectOne("ufc.selectufc", id);
	    }
		
		/*
		// 테이블에 데이터를 삽입하는 메소드
		public int insertInsect(UfcVO ufc) {
			return sqlSession.insert("ufc.insertufc",ufc);
		}
		*/
	    
	    // Ufc 테이블에 데이터를 삽입하는 메소드
	    /*
	    public int insertufc(UfcVO vo) {
	    	return sqlSession.insert("ufc.insertufc", vo);
	    }
	    */
	    
	    public int insertprocedure(UfcVO vo) {
	    	return sqlSession.insert("ufc.insertproc", vo);
	    }

}

