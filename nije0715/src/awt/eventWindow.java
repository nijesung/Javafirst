package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eventWindow extends Frame {
	public eventWindow() {
		
		setBounds(300, 300, 400, 400); // 윈도우의 시작 좌표와 크기를 설정
		
		setTitle("event process"); // 윈도우의 제목을 설정
		
		Button btn1 = new Button("button01"); // 버튼을 생성
		
		Panel pa1 = new Panel(); // 여러 개의 컴포넌트들을 묶어 줄 패널 생성
		
		pa1.add(btn1); // 패널에 버튼을 추가
		
		add(pa1); // 패널을 윈도우에 추가
		
		// 버튼을 누를 때 이벤트 처리는 ActionListner 인터페이스가 처리한다
		ActionListener lisn1 = new ActionListener() { // 인터페이스는 항상 추상 메소드를 가지고 있다
			                                          // 그렇기에 오버로딩을 해야 된다

			@Override
			public void actionPerformed(ActionEvent e) { // 버튼이 눌러지면 호출되는 메소드
				System.exit(0); // 프로그램 종료
			}
			
		};
		btn1.addActionListener(lisn1); // 버튼과 리스너 연결
		                               // btn1 에 ActionListener 가 발생하면
		                               // listener1의 메소드를 호출하도록 설정
		
		setVisible(true); // 윈도우를 화면에 출력
	}

}
