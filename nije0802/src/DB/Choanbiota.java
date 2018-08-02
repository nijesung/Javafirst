package DB;

import java.sql.Date;

public class Choanbiota {
	
	private int num;
	private int population;
	private String specific_name;
	private Date detect_day;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getSpecific_name() {
		return specific_name;
	}
	public void setSpecific_name(String specific_name) {
		this.specific_name = specific_name;
	}
	public Date getDetect_day() {
		return detect_day;
	}
	public void setDetect_day(Date detect_day) {
		this.detect_day = detect_day;
	}
	
	@Override
	public String toString() {
		return "Choanbiota [num=" + num + ", population=" + population + ", specific_name=" + specific_name
				+ ", detect_day=" + detect_day + "]";
	}
	
	
	
	
	
	
	
	

}
