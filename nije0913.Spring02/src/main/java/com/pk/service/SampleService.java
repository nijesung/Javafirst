package com.pk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.dao.SampleDao;

// bean 을 자동 생성해 주는 어노테이션
@Service
public class SampleService {
	
	// 동일한 자료형의 bean 이 있으면 자동으로 연결해 주는 어노테이션
	// setter 메소드도 자동 생성해 준다.
	@Autowired
	private SampleDao sampleDao;
	
	public String test() {
		return sampleDao.test();
	}
}
