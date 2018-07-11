package api;

public class insect {
	
	private int volume;
	private String kind;
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	@Override
	public String toString() {
		return "insect [volume=" + volume + ", kind=" + kind + "]";
	}
	
	
	

}
