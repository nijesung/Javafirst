package event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class eventHandling01 extends Frame {

	public eventHandling01() { // 생성자
		
		setBounds(450, 450, 750, 750); // 위치와 크기 설정
		
		setTitle("event processing"); // 제목 설정
		
		Panel pa01 = new Panel(); // 여러 개를 배치하기 위해서 패널 소환
		
		TextField tf01 = new TextField(5); // 텍스트 필드 설정
		pa01.add(tf01);
		Label plus = new Label("+");
		pa01.add(plus);
		
		TextField tf02 = new TextField(5);
		pa01.add(tf02);
		Label assign = new Label("=");
		pa01.add(assign);
		
		TextField result = new TextField(5);
		pa01.add(result);
		
		Button btn = new Button("reckon");
		pa01.add(btn);
		
		// ActionListener 인터페이스의 anonymous class 생성
		ActionListener lisn = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String n1 = tf01.getText(); // 첫 번째와 두 번째 텍스트 필드의 내용 가져오기
				String n2 = tf02.getText();
				
				int r = Integer.parseInt(n1) + Integer.parseInt(n2); // 문자열을 정수로 변환해서 더하기
				
				result.setText(r+""); // 숫자를 문자열로 치환하는 쉬운 방법
			}
		};
		btn.addActionListener(lisn); // 버튼과 리스너 연결하기
		
		
		Label lbpw = new Label("password");
		pa01.add(lbpw);
		TextField pw = new TextField(15);
		pa01.add(pw);
		Label pwresult = new Label();
		pa01.add(pwresult);
		
		// 텍스트 필드의 내용이 변경될 때 처리할 수 있는 인터페이스의 인스턴스를 생성
		TextListener t1 = new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				String password = pw.getText();
				int da = 0; 
				int so = 0;
				int su = 0;
				int etc = 0;
				for(int i=0; i<password.length(); i = i+1) { // 각 글자를 순회
					char ch = password.charAt(i); // i 번의 글자 가져오기
					if(ch >= 'A' && ch <= 'Z') { // password 의 모든 대문자를 순회
						da = da + 1 ;
					}
				
				    else if(ch>='a' && ch<='z') { // password 의 모든 소문자를 순회
					    so = so + 1;
				    }
				    else if(ch>='0' && ch<='9') { // password 의 모든 숫자를 순회
				    	                          // 숫자가 아닌 문자를 입력받은 사실을 기억하자
					    su = su + 1;
				    }
				    else {
					    etc = etc + 1; // password 의 모든 특수문자를 순회 (남은 것은 특수문자 뿐이니까)
				    }
			
				pwresult.setText(da + "");
				
				}
				if(da * so * su * etc > 0) { // 4개 중에 한 개도 0이 없으면
					pwresult.setBackground(Color.blue);
					pwresult.setText("Safety password");
				}
				else {
					pwresult.setBackground(Color.RED);
					pwresult.setText("dangerous password");
				}
			}
			
		};
		pw.addTextListener(t1);
		
		
		add(pa01);
		
		setVisible(true); // 화면 출력
	}

  }
