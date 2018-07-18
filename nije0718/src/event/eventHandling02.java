package event;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class eventHandling02 extends Frame {
	public eventHandling02() {
		
		setBounds (150,150, 600,600);
		setTitle("Keyboard Event");
		setLayout(null);
		
		Label air = new Label("@");
		air.setBounds(200,200, 20,20);
		add(air);
		
		KeyListener keylisn = new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				
			}
			// 키보드에서 손을 뗄 때 호출되는 메소드
			@Override
			public void keyPressed(KeyEvent arg0) {
				int x = air.getLocation().x;
				int y = air.getLocation().y;
				if(arg0.getKeyCode() == arg0.VK_LEFT) {
					x = x - 10;
				}
				if(arg0.getKeyCode() == arg0.VK_RIGHT) {
					x = x + 10;
				}
				if(arg0.getKeyCode() == arg0.VK_UP) {
					y = y - 10;
				}
				if(arg0.getKeyCode() == arg0.VK_DOWN) {
					y = y + 10;
				}
				air.setLocation(x, y);
				// Modifiers 는 같이 누른 조합키 값을 리턴
				if(arg0.getModifiers() == KeyEvent.ALT_MASK && arg0.getKeyCode() 
						== KeyEvent.VK_F1) {
				System.exit(0);
				}
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					
					Label la01 = new Label("shot");
					la01.setBounds(air.getLocation().x , air.getLocation().y-30, 30, 30);
					add(la01);
					
					Thread th01 = new Thread() { // 스레드를 만들어서 실행
						public void run() {
							try {
								while(true) {
								Thread.sleep(500);
								int x = la01.getLocation().x;
								int y = la01.getLocation().y;
								la01.setLocation(x, y-5);
								if(y <50)
									break;
								}
								la01.setVisible(false);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}
					};
					th01.start();
				}
				
			}
		
			
			// 문자 키를 눌렀을 때 호출되는 메소드
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
			}
			
		};
		addKeyListener(keylisn); // Frame 에 키보드 이벤트 설정
		
		// 윈도우 조작을 위한 이벤트를 처리하는 레스너
		WindowAdapter winadap = new WindowAdapter() {


			@Override
			public void windowClosing(WindowEvent e) { // 종료 버튼을 누를 때 호출되는 메소드
				System.exit(0); // 프로그램 종료
				
			}

			
		};
		
		
		addWindowListener(winadap); // 프레임에 윈도우 이벤트 연결
		
		setVisible(true);
	}

}
