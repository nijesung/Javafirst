package com.pk.ufc.service;

import java.util.List;
import com.pk.domain.ufc;

public interface UfcService {
	//전체 데이터를 가져오는 메소드
		//파라미터가 없으면 Dao 메소드와 동일한 구조입니다.
		public List<ufc> listufc();
	
}
