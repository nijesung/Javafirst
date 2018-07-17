package awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;

public class commonsDialog extends Frame {
	public commonsDialog() {
		setBounds(200, 200, 600, 600);
		setTitle("international chat box");
		
		FileDialog fileDialog = new FileDialog(this, "flie chay box"); // 파일 대화상자 만들기
		
		fileDialog.setDirectory("C:\\Users\\503-11\\Desktop\\test");

		
		fileDialog.setVisible(true); // 파일 대화상자를 화면에 출력
		
		String filePath = fileDialog.getDirectory() + fileDialog.getFile(); // 선택한 파일 경로 가져오기
	//	System.out.println(filePath);
		
		Label label = new Label(filePath);
		add(label);
		
		
		setVisible(true);
	}

}
