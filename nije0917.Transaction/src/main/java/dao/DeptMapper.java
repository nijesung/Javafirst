package dao;

import org.apache.ibatis.annotations.Insert;

import vo.Dept;

public interface DeptMapper {
	
	// dept 테이블에 데이터를 저장하는 메소드
	@Insert("insert into dept01 values(#{deptno}, #{dname}, #{loc})")
	public int insertdept(Dept dept);

}
