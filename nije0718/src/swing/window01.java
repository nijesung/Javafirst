package swing;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



public class window01 extends JFrame { // 윈도우 클래스 생성
	
	public window01() {
		
		setBounds(400, 400, 600, 600); // 위치와 크기 설정
		
		setTitle("Swing Window"); // 제목 설정
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 종료 버튼 이벤트 처리
		
		JPanel pa1 = new JPanel(); // 패널을 생성
		ImageIcon icon = new ImageIcon("C:\\Users\\503-11\\Desktop\\test\\insect.png");
		
		JLabel la1 = new JLabel();
		la1.setToolTipText("hiiiiiiiiiii");
	 //	TitledBorder border = new TitledBorder("horizone");
	 	EtchedBorder border = new EtchedBorder(Color.RED, Color.BLUE);
	 	la1.setBorder(border);
		pa1.add(la1);

		
		
		String[]images = {"insect.png", "insect02.png", "insect03.png"}; // 배열은 크기 변경이 안된다
		                                                                 // 보여주고 싶은 그림파일을
		                                                                 // 배열로 생성
		
		ArrayList<String> list = new ArrayList<String>(); // 리스트는 크기 변경이 가능한 배열이다
		list.add("insect.png");
		list.add("insect02.png");
		list.add("insect03.png");
		
		
		Thread th = new Thread() { // 이미지가 변경되는 동안에도 다른 작업을 할 수 있어야 하므로 이미지 변경은 스레드로 생성
			public void run() {
				int idx = 0; // 교대로 처리하고 싶을 경우
				while(true) {
					try {
						Thread.sleep(500); // 주기
						ImageIcon icon = new ImageIcon("C:\\Users\\503-11\\Desktop\\test\\"
					 //	+ images[idx%images.length]); // 배열로 추가하고 싶을 경우
						+ list.get(idx%list.size())); // 리스트로 추가하고 싶을 경우
						la1.setIcon(icon);
						
						
						idx = idx + 1; // 교대로 처리하고 싶을 경우(2)
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		};
		th.start();
		
		JButton btn = new JButton("button");
		pa1.add(btn);
		
		add(pa1); // 패널을 프레임에 부착
		setVisible(true); // 화면 출력
	}
	
	

}
