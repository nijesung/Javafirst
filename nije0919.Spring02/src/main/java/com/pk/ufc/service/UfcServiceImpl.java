package com.pk.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.ufc.dao.UfcDao;
import com.pk.domain.ufc;

@Service
public class UfcServiceImpl implements UfcService {

	@Autowired
	private UfcDao ufcDao;
	
	@Override
	//파라미터가 없는 경우는 Dao 메소드의 결과를 바로 리
	public List<ufc> listufc() {
		return ufcDao.listUfc();
	}

}
