package awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;

public class insectDialog extends Frame {
	
	// 생성자 - 인스턴스를 생성할 때 호출하는 메소드
	public insectDialog() {
		
		setBounds(150, 150, 500, 500); // 위치와 크기를 설정
		                               // 앞의 2개가 위치, 뒤의 2개가 크기
		
		setTitle("insect chat box"); // 제목 설정
		
		// FileDialog 객체를 생성해서 화면에 출력하고 선택한 파일 경로를 레이블에 출력
		// FileDialog 를 생성할 때 첫 번째 매개변수가 Dialog 나 Frame 의 주소인데
		// 지금의 경우는 This 를 대입하면 된다
		
		FileDialog fileDialog = new FileDialog(this, "insect chat box"); // FileDialog 인스턴스 생성
		
		fileDialog.setDirectory("C:\\Users\\503-11\\Desktop\\test");
		
		fileDialog.setVisible(true); // 파일 대화상자를 화면에 출력
		
		String filePath = fileDialog.getDirectory() + fileDialog.getFile(); // 파일 경로 가져오기
		
		Label label = new Label(filePath); // 레이블 생성
		add(label); // 현재 프레임 위에 올리기
		
		setVisible(true); // 화면 출력
	}

}
