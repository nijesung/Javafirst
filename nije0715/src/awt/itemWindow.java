package awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class itemWindow extends Frame {
	
	public itemWindow() {
		setBounds(200, 200, 500, 400);
		setTitle("event handling");
		
		Panel northpa1 = new Panel();
		Checkbox chbird = new Checkbox("bird");
		Checkbox chman = new Checkbox("man");
		Checkbox chcat = new Checkbox("cat");
		Checkbox chlizard = new Checkbox("lizard");
		Checkbox chspringtail = new Checkbox("springtail");
		
		northpa1.add(chbird);
		northpa1.add(chman);
		northpa1.add(chcat);
		northpa1.add(chlizard);
		northpa1.add(chspringtail);
		
		TextArea ta = new TextArea(10,70); // 중앙에 텍스트에어리어 배치
		add("Center", ta);
		
		add("North", northpa1);
		
		// 콤보박스 2개 배치
		// 콤보박스에 배치할 데이터 만들기
		String[]category = {"bird", "man", "cat", "lizard", "springtail"};
		String []content = {"subspecies","subspecies2","subspecies3"};
		
		Choice cbcategory = new Choice();
		for(String imsi : category) {
			cbcategory.add(imsi);
		}
		Choice cbcontent = new Choice();
		for(String imsi : content) {
			cbcontent.add(imsi);
		}
		
		Button btnsel = new Button("select");
		Button btnexit= new Button("exit");
		
		Panel southPanel = new Panel();
		southPanel.add(cbcategory);
		southPanel.add(cbcontent);
		southPanel.add(btnsel);
		southPanel.add(btnexit);
		
		add("South", southPanel);
		
		ItemListener itemHandler1 = new ItemListener() { // 체크 박스를 눌렀을 때 호출될 메소드

			@Override
			public void itemStateChanged(ItemEvent e) {
		 //	ta.append(e.getSource().toString()+"is push" + "\n");
				Checkbox cb = (Checkbox)(e.getSource()); // 이벤트가 발생한 인스턴스를 원래의 자료형인 체크박스로 변환
				                                         // 이벤트 처리 메소드에서 e.getSource() 는
				                                         // 이벤트가 발생한 인스턴스의 주소를 리턴한다
				String label = cb.getLabel(); // 체크 박스에 입력된 텍스트 가져오기
				
				boolean b = cb.getState(); // 체크 박스 선택 여부 가져오기
				ta.append(label + " " + "for change \n");
				/*
				chbird.addItemListener(itemHandler1);
				chman.addItemListener(itemHandler1);
				chcat.addItemListener(itemHandler1);
				chlizard.addItemListener(itemHandler1);
				chspringtail.addItemListener(itemHandler1);
				*/
				
				// 카테고리 콤보 박스의 선택이 변경되었을 때 호출될 메소드를 가진 Listener
				// ItemListener 가 처리
				
				ItemListener itemHandler2 = new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) { 
						int row = cbcategory.getSelectedIndex(); // cbcategory의 선택된 행 번호 가져오기
						cbcontent.removeAll(); // // cbcontent의 내용을 전부 삭제
						
						for(String temp : content) { // 행 번호에 해당하는 세부 내용을 cbcontent 에 추가
							cbcontent.add(temp);
						}
						
						
						
						
					}
					
				};
			}
		};
		
	//	cbcategory.addItemListener(itemHandler2);
		
		ActionListener action1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int caNum = cbcategory.getSelectedIndex();
				int coNum = cbcontent.getSelectedIndex();
				String categoryText = category[caNum];
				String contentText = content[coNum];
				ta.setText(categoryText + ":" + contentText);
				
			}
			
		};
		btnsel.addActionListener(action1);
		
		// 종료 버튼을 누르면 프로그램을 종료
		// System.exit(0);
		ActionListener action2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		};
		btnexit.addActionListener(action2);
		
		setVisible(true);
	}

}
