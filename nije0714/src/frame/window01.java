package frame;

import java.awt.Frame;

import java.awt.Panel;
import java.awt.Dialog;
import java.awt.Button;
import java.awt.Color;

public class window01 extends Frame {
	
	public window01() { // 생성자
		Dialog dialog = new Dialog(this, "대화상자");
		dialog.setSize(300, 300);
		
		setBackground(Color.GRAY);
		setSize(400, 400);
		setLocation(300, 300);
		setTitle("나의 퍼스트 창문");
		
		Button btn1 = new Button("종료"); 
	 // add(button); // 기본적으로 버튼이 윈도우 창만큼 크기가 설정되어 있다
     // colorThread th1 = new colorThread(btn1); // 버튼의 배경색을 변경하는 스레드
		Thread th1 = new Thread() {
			public void run() {
				Color [] colors = {Color.cyan, Color.blue, Color.GREEN};
				int idx = 0;
				while(true) {
					try {
						Thread.sleep(1000);
						idx = idx + 1;
						btn1.setBackground(colors[idx%colors.length]);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
        th1.start();
		Panel pa1 = new Panel();
	 // pa1.add(btn1);
		add(pa1); // 패널을 프레임에 추가
		
		Button btn2 = new Button("실행");
	 // textThread th2 = new textThread(btn2); // 버튼의 텍스트를 변경하는 스레드
	 // th2.start();
		
		Panel pa2 = new Panel();
	 //	pa2.add(btn2);
		add(pa2);
		
		
		setVisible(true);
		
	}
}

	

