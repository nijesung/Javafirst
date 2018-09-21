package com.pk.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pk.domain.Fruit;

// bean 을 자동으로 만들어 주는 어노테이션
@Repository
public class FruitDao {
	// 동일한 자료형의 bean 이 있는 경우 자동으로 주입받는 설정
	@Inject
	// 하이버네이트를 사용하기 위한 인스턴스 변수
	private SessionFactory sessionFactory;
	
	// 메소드에서 예외가 발생하면 rollback 되고 예외가 발생하지 않으면 commit 되도록 해 주는 어노테이션
	@Transactional
	// 데이터를 삽입하는 메소드
	public void insertFruit(Fruit fruit) {
		sessionFactory.getCurrentSession().save(fruit);
	}
	
	@Transactional
	// 데이터를 수정하는 메소드
	public void updateFruit(Fruit fruit) {
		sessionFactory.getCurrentSession().update(fruit);
	}
	
	@Transactional
	// 데이터를 삭제하는 메소드
	public void deleteFruit(Fruit fruit) {
		sessionFactory.getCurrentSession().delete(fruit);
	}
	
	@Transactional
	// 전체 데이터를 조회하는 메소드
	public List<Fruit> list(){
		return (List<Fruit>)sessionFactory.getCurrentSession().createCriteria(Fruit.class).list();
	}
	
	@Transactional
	// code 를 가지고 데이터를 조회하는 메소드
	public Fruit get(int code) {
		return(Fruit)sessionFactory.getCurrentSession().get(Fruit.class, code);
	}

}
