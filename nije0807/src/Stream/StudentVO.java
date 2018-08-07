package Stream;

public class StudentVO {
	// 테이블의 각 컬럼의 값들을 저장하기 위해서 생성
	private String studnum;
	private String name;
	private String department;
	private int score;
	private int age;
	private String gender;
	
	public StudentVO(String studnum, String name, String department, int score, int age, String gender) {
		super();
		this.studnum = studnum;
		this.name = name;
		this.department = department;
		this.score = score;
		this.age = age;
		this.gender = gender;
	}
	
	// 인스턴트 생성을 할 때 데이터를 바로 대입해서 생성하면 메소드 호출횟수를 줄일 수 있기 때문에 생성
	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    // 인스턴스 변수를 private 으로 생성했기 때문에 인스턴스가 사용할 수 없어서 인스턴스 변수를 사용하기 위한 메소드
	public String getStudnum() {
		return studnum;
	}

	public void setStudnum(String studnum) {
		this.studnum = studnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// 데이터를 빠르게 확인하기 위해 생성 - 디버깅을 위해
	@Override
	public String toString() {
		return "StudentVO [studnum=" + studnum + ", name=" + name + ", department=" + department + ", score=" + score
				+ ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
	

}
