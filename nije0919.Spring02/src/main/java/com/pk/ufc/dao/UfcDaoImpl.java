package com.pk.ufc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.domain.ufc;

@Repository
public class UfcDaoImpl implements UfcDao {
	//MyBatis 실행 객체를 주입
		@Inject
		private SqlSession sqlSession;

		@Override
		public ufc getufc(int ufcid) {
			return sqlSession.selectOne("ufc.getufc", ufcid);
		}

		@Override
		public List<ufc> listUfc() {
			// TODO Auto-generated method stub
			return null;
		}




	}
