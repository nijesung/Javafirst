package service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DeptMapper;
import vo.Dept;

@Service
public class DeptService {
	@Inject
	private DeptMapper deptMapper;
	
	// 데이터를 삽입하는 메소드
	@Transactional
	public void insertdept() {
		Dept dept = new Dept();
		dept.setDeptno(13);
		dept.setDname("fun");
		dept.setLoc("you");
		
		deptMapper.insertdept(dept);
		deptMapper.insertdept(dept);
	}
}
