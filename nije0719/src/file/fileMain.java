package file;

import java.io.File;
import java.sql.Date;


public class fileMain {

	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\503-11\\Desktop\\test\\insect.png"); // 정보를 확인할 수 있는 클래스의 인스턴스를 생성
		
		System.out.println(f.exists()); // 파일의 존재 여부
		
	    long size = f.length(); // 파일의 크기
	    System.out.println(size/1024 + "k");
	    
	    Date date = new Date(f.lastModified()); // 파일의 최후 수정시간
	    System.out.println(date);
	    
	    File file = new File("C:\\Users\\503-11\\Desktop\\test\\insecttest.png");
	    String parent = file.getParent();
	    String filename = file.getName();
	    
     // filename 에서 15. 을 제거한 부분을 가져오기
	    int idx = filename.indexOf('.'); //.의 위치를 찾아서 . 이후의 문자열 가져오기
	                                     // . 이 존재한다면: 위치를 찾는 메소드는 찾고자 하는 데이터가 없으면 음수를 리턴
	    if(idx >=0) { 
	    	
	    	filename = filename.substring(idx+1); // 문자열을 위치를 가지고 자르는 메소드는 substring
	    }
	    System.out.println(filename);
	    
	    String newFile = parent + filename;
	    System.out.println(newFile);
	    file.renameTo(new File(parent, filename)); // 이름 바꾸기
	    
	    

	}

}
