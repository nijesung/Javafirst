package com.pk.ufc.dao;

import java.util.List;

import com.pk.domain.ufc;


public interface UfcDao {
	// Ufc 테이블의 전체 데이터를 가져오는 메소드
	public List<ufc> listUfc();
	
	public ufc getufc(int ufcid);
		    
	}


