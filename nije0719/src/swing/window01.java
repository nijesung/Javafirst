package swing;

import java.awt.Panel;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class window01 extends JFrame { // 윈도우 클래스 - JFrame 으로 상속받으면 항상 윈도우 클래스가 만들어 진다
	String[] data = {"insect", "bug", "luminous", "timid"}; // 배열을 먼저 만들어준다
	public window01() {
		
		this.setBounds(300, 300, 600, 600);
		this.setTitle("swing");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JList<String> list = new JList<>(data);
		JComboBox<String>combo = new JComboBox(data);
		
		JPanel pa1 = new JPanel();
		pa1.add(list);
		pa1.add(combo);
		
		add(pa1);
		
		setVisible(true);
	}

}
