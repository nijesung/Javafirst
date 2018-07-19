package swing;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class phylogenetic extends JFrame {
	public phylogenetic() {
		// 컬럼 이름 배열
		String[] columns = {"name", "volume", "kind"};
		
		String[][] data = {
				          {"Cicindela" ,"2cm", "insect"},
				          {"Tarantula" ,"10cm", "Arthropoda"},
		                  {"springtail" ,"1cm", "Collembola"},
		                  {"centiped " ,"8cm", "Arthropoda"}
		                  };
		
		this.setBounds(300, 300, 900, 700);
		this.setTitle("kind");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DefaultTableModel model = new DefaultTableModel(data, columns); // 테이블 모델 만들기
		JTable table = new JTable(model); // 테이블 모델을 이용해서 테이블을 만들기
		
		JScrollPane scroll = new JScrollPane(table); // 출력 영역의 크기보다 table 이 커지더라도
		                                            // 스크롤 바를 이용할 수 있도록 Scroll 을 생성
		
		add(scroll); // 스크롤 패인을 프레임에 부착
		
		JLabel jlname = new JLabel("name");
		JTextField jtname = new JTextField(10);
		
		JLabel jlvolume = new JLabel("volume");
		JTextField jtvolume = new JTextField(15);
		
		JLabel jlkind = new JLabel("kind");
		JTextField jtkind = new JTextField(15);
		
		JButton btnInsert = new JButton("insert");
		JButton btnDelete = new JButton("delete");
		
		JPanel southPanel = new JPanel();
		southPanel.add(jlname);
		southPanel.add(jtname);
		southPanel.add(jlvolume);
		southPanel.add(jtvolume);
		southPanel.add(jlkind);
		southPanel.add(jtkind);
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);
		
		add("South", southPanel);
		
		setVisible(true);
		
		
		ActionListener inlisn = new ActionListener() { // 삽입 버튼의 클릭 이벤트(ActionListener) 처리

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = jtname.getText(); // 텍스트 빌드에 입력된 내용을 가져온다
				String volume = jtvolume.getText();
				String kind = jtkind.getText();
				
				
				name = name.trim(); // 좌우 공백 제거하기
				volume = volume.trim();
				kind = kind.trim();
				
				
				if(name.length() == 0) { // name 의 필수 입력 설정
					                     // 이름을 가져올 때는 길이를 물어보아야 한다 (길이가 0)
					                     // Null 과 혼동하지 않도록 한다
					JOptionPane.showMessageDialog(null, "please try naming","name" ,
							JOptionPane.WARNING_MESSAGE); 
					return; // 아래쪽을 더 이상 수행하지 않도록 리턴
				}
				
				// 테이블의 데이터를 편집하기 위해서 테이블의 데이터 모델을 가져온다.
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				
				String[]row = {name, volume, kind}; // 데이터를 추가하기 위해 추가할 데이터 배열을 생성
				
				model.addRow(row); // 모델에 추가
				
				table.updateUI(); // 테이블을 갱신
				
				jtname.setText(""); // 텍스트 필드 클리어
				jtvolume.setText("");
				jtkind.setText("");
				
				JOptionPane.showMessageDialog(null, "input data complete","input" ,
						JOptionPane.PLAIN_MESSAGE); // 메시지 박스 출력
				
				
			}	
		};
		btnInsert.addActionListener(inlisn);
		
		ActionListener deletelisn = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow(); // 선택한 행 번호 찾기
				                                  
				
			//	if(!(idx >=0 && idx<table.getRowCount())) { // 테이블에서 행을 선택하지 않았다면
				if(idx < 0 || idx>=table.getRowCount()) {
					JOptionPane.showMessageDialog(null, "Please row check","delete fail !" ,
							JOptionPane.WARNING_MESSAGE); // 메시지 박스 출력
					return;
				}
				
				
				DefaultTableModel model = (DefaultTableModel)table.getModel(); // 테이블의 모델 가져오기
				                                                               //형 변환을 해 준다 
				
				
				model.removeRow(idx); // 행에 해당하는 데이터 지우기
				table.updateUI();
				JOptionPane.showMessageDialog(null, "delete data complete","delete" ,
						JOptionPane.WARNING_MESSAGE); // 메시지 박스 출력
				
			}
		};
		btnDelete.addActionListener(deletelisn);
		
		// 메시지 다이얼로그 출력 - 첫 번째가 메시지 다이얼로그, 두 번째가 대화상자 이다
	// 	JOptionPane.showMessageDialog(null, "what","the",JOptionPane.QUESTION_MESSAGE);
		/*
		int r = // 선택 다이얼로그 출력
		JOptionPane.showConfirmDialog(null, "what","the",JOptionPane.YES_NO_OPTION);
		System.out.println(r);
		*/
		
		// 한 줄 입력받는 다이얼로그 출력
		/*
		String r1 = JOptionPane.showInputDialog(null, "what","the",JOptionPane.YES_NO_OPTION);
		System.out.println(r1);
		*/
		/*
		JMenuBar menubar = new JMenuBar(); // 항상 메뉴 바를 먼저 생성
		
		JMenu file = new JMenu("file(a)");
		file.setMnemonic('a'); // 단축키 설정
		
		JMenuItem item01 = new JMenuItem("open");
		file.add(item01);
		
		JCheckBoxMenuItem item02 = new JCheckBoxMenuItem("save");
		file.add(item02);
		
		JRadioButtonMenuItem item03 = new JRadioButtonMenuItem("edit");
		file.add(item03);
		
		menubar.add(file);
		
		setJMenuBar(menubar); // 메뉴 바를 윈도우에 부착
		*/
		
		
	}

}
