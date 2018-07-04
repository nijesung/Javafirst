package Inheritance;

public class Main {

	public static void main(String[] args) {
		Employee emp1 = new Employee(0); // 객체의 내용을 확인하고자 하면 System.out.println 메소드에
		System.out.println(emp1);       // 객체의 이름만 대입
		
		Employee emp2 = new Employee(0); // static 은 유지되고 있기 때문에 값이 더해진다
        System.out.println(emp2);
        
        Employee emp10 = new Employee(0);
        System.out.println(emp10);
        
        Employee emp9 = new Employee(0);
        System.out.println(emp9);
        
        Manager man1 = new Manager();
        System.out.println(man1);
        
        Manager man2 = new Manager();
        System.out.println(man2);

	}
	

}
