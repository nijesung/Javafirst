package awt;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;



public class loginWindow extends Frame {
	
	public loginWindow() { // 생성자 - 인스턴스를 만들 때 호출하는 메소드
		
		setSize(600, 600);
		setLocation(300, 300);
		setTitle("Login");
		
		Panel pa1 = new Panel(); // 패널을 생성
		Label lblId = new Label("i-d");
		TextField txtId = new TextField(20);
		pa1.add(lblId);
		pa1.add(txtId);
		
		Label lblPw = new Label("passward");
		TextField txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		pa1.add(lblPw);
		pa1.add(txtPw);
		
		TextArea ta= new TextArea(15, 55); // 여러 줄 입력할 수 있는 텍스트 영역 만들기
		pa1.add(ta);
		add(pa1); // 패널을 프레임에 부착
		
		MenuBar menubar = new MenuBar(); // 메뉴 바 만들기
		
		Menu file = new Menu("file(F)"); // 메뉴 생성
		
		menubar.add(file); // 메뉴를 메뉴 바에 부착
		
		MenuItem newFile = new MenuItem("new");
		file.add(newFile);
		MenuItem save = new MenuItem("save");
		file.add(save);
		
		Menu edit = new Menu("edit");
		MenuItem copy = new MenuItem("radiation");
		edit.add(copy);
		file.add(edit);
		
		
		setMenuBar(menubar); // 메뉴 바를 윈도우에 배치
		 
		setVisible(true); //화면 출력
		
	}

}
