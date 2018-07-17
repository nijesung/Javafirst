package awt;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.Random;

public class layoutFrame extends Frame {
	public layoutFrame() {
		
		setBounds(150, 150, 500, 500); // 위치와 크기를 설정
                                       // 앞의 2개가 위치, 뒤의 2개가 크기

        setTitle("layout chat box"); // 제목 설정
        
        
        Panel pa1 = new Panel();
        /*
     // pa1.setLayout(new FlowLayout()); // Panel 의 레이아웃을 설정
        pa1.setLayout(new BorderLayout());
        
        Button btn = null;
        for(int i = 0; i<6; i=i+1) { // 컴포넌트 배치
         //	Button btn = new Button("button" + i);
        	btn = new Button("button" + i);
        	pa1.add(btn);
        }
        */
        /*
        pa1.setLayout(new BorderLayout());
        
        Button btnWest = new Button("west");
        pa1.add("west", btnWest);
        Button btnEast = new Button("east");
        pa1.add("east", btnEast);
        Button btnCenter = new Button("center");
        pa1.add("center", btnCenter);
        */
        /*
        pa1.setLayout(new GridLayout(2, 3, 10, 10));
        for(int i=0; i<6; i=i+1) {
        	Button btn = new Button("button" + i);
        	pa1.add(btn);
        }
        */
        
        
        add(pa1);
        setResizable(false); // 프레임 크기 조정 불가능
        
        pa1.setLayout(null); // null 은 컴포넌트의 크기와 위치를 마음대로 변경할 수 있다.
        Label label = new Label("@");
        label.setBounds(10, 50, 30 , 50);
        add(label);
        /*
        setVisible(true); // 화면 출력
        Thread th1 = new Thread() {
        	int sign = 10;
        	public void run() {
        		while(true) {
        			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			int x = label.getLocation().x;
        			int y = label.getLocation().y;
        			if(x >=300) {
        				sign = -10;
        			}
        			if(x<=10) {
        				sign = 10;
        			}
        			label.setLocation(x+sign,y);
        		}
        	}
        };
        th1.start();
        */
        
        Thread th1 = new Thread() {
        	public void run() {
        		while(true) {
        			int x = label.getLocation().x;
        			int y = label.getLocation().y;
        			Random r = new Random();
        			label.setLocation(
        			r.nextInt(300), r.nextInt(300));
        			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
        		}
        	}
        };
        th1.start();
	}

}
