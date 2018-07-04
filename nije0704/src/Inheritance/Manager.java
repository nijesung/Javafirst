package Inheritance;
import Inheritance.Employee;

public class Manager extends Employee { // Employee 클래스를 상속받은 Manager 클래스가 된다
	
	public Manager() { // 이렇게 생성자를 직접 만들어서 상위 클래스의 생성자를 부르는 경우는 안드로이드에서 많이 발생한다.
		super(10);     // spuer() 는 반드시 첫 번째 줄에 있어야 한다
	}
	

	private String task;

	public String getTask() { // 메소드 원형: GetTask()
		return task;
	}

	public void setTask(String task) { // 메소드 원형: setTask(String)
		this.task = task;
	}

 // @Override
 // public String toString() {
	//	return "Manager [task=" + task + "]";
 // }
	
	@Override 
	public String toString() { // super.toString() 은 상위 클래스 인 Employee 의 toString을 호출한다.
		return super.toString() + "Manager [task=" + task + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
