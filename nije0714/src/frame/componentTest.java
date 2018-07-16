package frame;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

import javafx.scene.control.CheckBox;

public class componentTest extends Frame {
	
	public componentTest() {
		setTitle("test");
		setLocation(200,200);
		setSize(600,600);
		
		Panel pa = new Panel();
		
		CheckBox cb1 = new CheckBox("reading");
		CheckBox cb2 = new CheckBox("mma");
		CheckBox cb3 = new CheckBox("meditation");
		CheckBox cb4 = new CheckBox("game");
		/*
		pa.add(cb1);
		pa.add(cb2);
		pa.add(cb3);
		pa.add(cb4);
		*/
		
		// 라디오 버튼 만들기
		CheckboxGroup group = new CheckboxGroup();
		Checkbox man = new Checkbox("man", group, true);
		Checkbox woman = new Checkbox("woman", group, false);
		
		Choice ch = new Choice();
		ch.add("1");
		ch.add("2");
		ch.add("3");
		ch.add("4");
		pa.add(ch);
		
		pa.add(man);
		pa.add(woman);
		
		List list = new List(5, true); // 5개를 보여주고 여러 개를 선택할 수 있도록 해주는 리스트
		list.add("java siro");
		list.add("java javan");
		list.add("java bora");
		pa.add(list); // list 의 remove(int idx) 를 이용하면 idx 번 째를 지울 수 있다
		              // list.remove(0);
		              // 첫 번째와 세 번째를 제거해보도록 하렴
		              // 여러 개를 지울 때는 뒤에서 부터 삭제해야 한다
		list.remove(3);
		list.remove(1);
		
		add(pa);
		setVisible(true);
	}

}
