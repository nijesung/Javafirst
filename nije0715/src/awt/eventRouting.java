package awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eventRouting extends Frame {
	public eventRouting() {

		setBounds(400, 400, 500, 500); // 윈도우의 시작 좌표와 크기를 설정

		setTitle("event Routing"); // 윈도우의 제목을 설정

		Button btn1 = new Button("button01"); // 버튼을 생성
		Button btn2 = new Button("button02");
		Button btn3 = new Button("exit");
		
		Label label = new Label();

		Panel pa1 = new Panel(); // 여러 개의 컴포넌트들을 묶어 줄 패널 생성

		pa1.add(btn1); // 패널에 버튼을 추가
		pa1.add(btn2);
		pa1.add(btn3);
		add("Center", pa1);
		add("South", label);

		add(pa1); // 패널을 윈도우에 추가s
		/*
		ActionListener listener1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("your absolutely soccer");
			}
		};
		btn1.addActionListener(listener1);// 컴포넌트와 이벤트를 처리할 수 있는 리스너를 연결
		
		ActionListener listener2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("your absolutely peace suit");
			}
		};
		btn2.addActionListener(listener2);
		
		ActionListener listener3 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("your mother pumkin suit");
				System.exit(0);
			}
		};
		btn3.addActionListener(listener3);
		*/
		// 이벤트 라우팅 - 하나의 리스너가 여러 컴포넌트의 이벤트를 처리하는 것
		ActionListener listener1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()){
					case "button01":
						label.setText("your absolutely soccer");
						break;
					case "button02":
						label.setText("your absolutely peace suit");
						break;
					case "exit":
						label.setText("your mother pumkin suit");
						System.exit(0);
						break;
				}
				
			}
			
		};
		btn1.addActionListener(listener1); // 3개 버튼의 액션 이벤트를 listener 가 모두 처리
		btn2.addActionListener(listener1);
		btn3.addActionListener(listener1);
		
		setVisible(true); // 윈도우를 화면에 출력
	}

}
