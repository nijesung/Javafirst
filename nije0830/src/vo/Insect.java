package vo;

public class Insect {
	protected String name;
	protected int size;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		System.out.println("배고파");
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
