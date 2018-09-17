package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pk.mybatis.domain.UfcVO;

public interface UfcInterface {
	// ufc 테이블의 데이터를 전부 가져오는 메소드
	@Select("select * from ufc")
	public List<UfcVO> listufc();
	
	// ufc 테이블에서 id 가 일치하는 데이터 1개를 가져오는 메소드
	@Select("select * from ufc where id=#{id}")
	public UfcVO selectufc(String id);

}
