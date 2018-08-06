package DB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ChoanView extends JFrame {
	
	// 데이터베이스 작업을 위한 Dao 변수
	ChoanbiotaDao dao = new ChoanbiotaDaoImpl();

	// 데이터베이스 에서 가져온 결과를 저장하기 위한 List
	List<Choanbiota> list;

	int idx;

	// 레이블 선언
	JLabel lblNum, lblSpecific_name, lblPopulation, lblDetect_day;

	// 입력받을 텍스트 필드 선언
	JTextField tfNum, tfSpecific_name, tfPopulation, tfDetect_day;

	// 버튼 변수
	JButton btnFirst, btnLast, btnPrev, btnNext;
	JButton btnInsert, btnUpdate, btnDelete, btnSearch, btnClear;

	// 현재 출력 중인 데이터의 인덱스를 표시할 레이블
	JLabel lblIndex;

	// idx 번 째 데이터를 화면에 출력해 주는 메소드
	// 맨 처음 한 번 호출하고 데이터에 작업이 발생하면 호출하는 메소드
	private void printData() {
		// 읽을 데이터가 없다면 메시지 박스를 출력하고 리턴
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "읽을 데이터가 없습니다.", "데이터 없음", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// List 에서 idx 번 째 데이터를 가져온다
		Choanbiota choanbiota = list.get(idx);
		tfSpecific_name.setText(choanbiota.getSpecific_name());
		tfNum.setText(choanbiota.getNum() +""); // int 일 때는 +"" 잊지말기
		tfPopulation.setText(choanbiota.getPopulation() +""); // int 일 때는 +"" 잊지말기
		tfDetect_day.setText(choanbiota.getDetect_day().toString());
		
		// 레이블에 현재 인덱스를 출력
		lblIndex.setText((idx + 1) +"");
	}

	public ChoanView() {

		// 중앙에 배치할 패널 생성
		JPanel centerPanel = new JPanel();

		// 레이블을 생성
		lblNum = new JLabel("혐오도 랭킹", JLabel.RIGHT);
		lblSpecific_name = new JLabel("종명", JLabel.RIGHT);
		lblPopulation = new JLabel("개체수", JLabel.RIGHT);
		lblDetect_day = new JLabel("발견일자", JLabel.RIGHT);

		// 텍스트 필드 생성
		tfNum = new JTextField();
		tfSpecific_name = new JTextField();
		tfPopulation = new JTextField();
		tfDetect_day = new JTextField();

		centerPanel.setLayout(new GridLayout(4, 2, 3, 3)); // 4행 2열 배치될 수 있는 레이아웃으로 변경
		centerPanel.add(lblNum);
		centerPanel.add(tfNum);

		centerPanel.add(lblSpecific_name);
		centerPanel.add(tfSpecific_name);

		centerPanel.add(lblPopulation);
		centerPanel.add(tfPopulation);

		centerPanel.add(lblDetect_day);
		centerPanel.add(tfDetect_day);

		add("Center", centerPanel);

		// 버튼 생성
		btnFirst = new JButton("처음으로");
		btnFirst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "첫 번째 데이터 입니다.", "조회 에러", JOptionPane.ERROR_MESSAGE);
				idx = 0;
				printData();
			}
		});
		
		btnPrev = new JButton("이전으로");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idx == 0) {
					JOptionPane.showMessageDialog(null, "첫 번째 데이터 입니다.", "조회 에러", JOptionPane.ERROR_MESSAGE);
					return;
				}
				idx = idx - 1;
				printData();
			}
		});
		
		btnNext = new JButton("다음으로");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idx = idx + 1;
				if (idx == list.size()) {
					idx = 0;
				}
				printData();
			}
		});
		
		btnLast = new JButton("마지막으로");
		btnLast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "마지막 데이터 입니다.", "조회 에러", JOptionPane.ERROR_MESSAGE);
				idx = 0;
				printData();
			}
		});
		
		btnSearch = new JButton("조회");
		btnInsert = new JButton("삽입");
		
	    btnInsert.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// lblIndex의 텍스트가 삽입이 아니면 메시지 박스를 출력하고 함수의 수행을 종료
				// 문자열의 동일성 여부는 == 가 아니고 equals 로 해야 한다.
				if(lblIndex.getText().equals("삽입") == false) {
					JOptionPane.showMessageDialog(null, "지우고 기재하시오", "삽입에러",JOptionPane.ERROR_MESSAGE);
	                return;
				}
				// 입력한 데이터를 가져오기
				String num = tfNum.getText();
				String population = tfPopulation.getText();
				String specific_name = tfSpecific_name.getText();
				String detect_day = tfDetect_day.getText();
				
				// specific_name 은 필수 입력이고 1자 이상 입력했는지 검사
				if(specific_name.trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "종명은 1자 이상", "종명 오류",JOptionPane.ERROR_MESSAGE);
					return;
				}
				// population 전부 숫자인지 검사
				if(population.trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "개체수는 1자리 이상", "개체수 오류",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int i = 0;
				while(i<population.trim().length()) {
					char ch = population.trim().charAt(1);
					if(ch < '0' || ch > '9') {
						JOptionPane.showMessageDialog(null, "개체수는 숫자만", "개체수 오류",JOptionPane.ERROR_MESSAGE);
						return;
					}
					i = i + 1;
				}
				
				// Dao 의 메소드에 맞게 데이터를 생성
				Choanbiota choanbiota = new Choanbiota();
				choanbiota.setNum(list.get(idx).getNum());
				choanbiota.setPopulation(Integer.parseInt(population));
				choanbiota.setSpecific_name(specific_name);

				// detect_day 가 yyyy-mm-dd 형식으로 입력되었다고 가정하고 Date 타입으로 변경하기
				int year = Integer.parseInt(detect_day.substring(0, 4));
				int month = Integer.parseInt(detect_day.substring(4, 6));
				int day = Integer.parseInt(detect_day.substring(6));
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month);
				cal.set(Calendar.DAY_OF_MONTH, day);
				Date date = new Date(cal.getTimeInMillis());
				choanbiota.setDetect_day(date);
				
				// 데이터베이스 작업 수행
				dao.insertChoanbiota(choanbiota);
				
				// 작업 수행 후 재출력을 위해서 데이터를 다시 가져오고 인덱스 조정
				list = dao.allChoanbiota();
				idx = list.size() -1;
				printData();
				
				// 대화상자 출력하기
				JOptionPane.showMessageDialog(null, "삽입 성공", "데이터 삽입",JOptionPane.INFORMATION_MESSAGE);
				
			}
	    	
	    });
		
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String num = tfNum.getText();
				String specific_name = tfSpecific_name.getText();
				String population = tfPopulation.getText();
				String detect_day = tfDetect_day.getText();
				
				// specific_name 의 데이터가 비어있으면 메시지 박스를 출력하고 리턴하기
				if(specific_name.trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "이름은 필수 입력 사항입니다.", "입력 오류",JOptionPane.ERROR_MESSAGE);
				    return;
				}
				
				// 날짜 데이터가 년도 4자리 - 월 2자리 형식인지 조사
				int i = 0;
				if(detect_day.length() != 10) {
					JOptionPane.showMessageDialog(null, "발견일자 는 10자리로 만들어 주십시오", "입력 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				while(i < detect_day.length()) {
					char ch = detect_day.charAt(1);
					// 첫 번째부터 네번째 까지 숫자가 아니면 반복문 종료
					if(i >= 0 & i <= 3) {
						if(ch < '0' || ch > '9') { // 0~9 까지인지 알 수 있는 가장 쉬운 방법(문자부터 문자까지)
							break;
						}
					}
					/*
					if(i == 4 || i == 7) {
						if(ch != '-') {
							break;
						}
					}
					if(i == 5) {
						if(ch != '0' && ch != '1') {
							break;
						}
					}
					if(i == 6) {
						if(ch < '0' || ch > '9') {
							break;
						}
					}
					if(i > 7) {
						if(ch < '0' || ch > '9') {
							break;
						}
					}
					*/
					
					i = i + 1;
				}
				// 유효성 검사에 실패하면 메시지 박스를 출력하고 리턴
				if(i != detect_day.length()) {
					JOptionPane.showMessageDialog(null, "발견일자 는 YYYY-MM-DD 형식", "입력 오류", JOptionPane.ERROR_MESSAGE);
				}
				
				Choanbiota choanbiota = new Choanbiota();
				choanbiota.setNum(list.get(idx).getNum());
				choanbiota.setPopulation(Integer.parseInt(population));
				choanbiota.setSpecific_name(specific_name);
				
				int year = Integer.parseInt(detect_day.substring(0, 4));
				int month = Integer.parseInt(detect_day.substring(5, 7));
				int day = Integer.parseInt(detect_day.substring(8));
				
				// Calendar 객체를 만들어서 입력한 데이터를 가지고 Calendar 를 수정
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month);
				cal.set(Calendar.DAY_OF_MONTH, day);
				
				// Calendar 객체를 이용해서 Date 객체 만들기
				Date date = new Date(cal.getTimeInMillis());
				choanbiota.setDetect_day(date);
				
				dao.updateChoanbiota(choanbiota);
				JOptionPane.showMessageDialog(null, "수정 성공.", "데이터 수정",JOptionPane.INFORMATION_MESSAGE);
				list = dao.allChoanbiota();
				printData();
				
				
			}	
		});
		
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(null, "정말로 삭제 하시겠는가?", "삭제",JOptionPane.YES_NO_OPTION);
				System.out.println(r);
				if(r == 0) {
					JOptionPane.showConfirmDialog(null, "삭제 성공", "삭제",JOptionPane.INFORMATION_MESSAGE);
					// 번호를 이용해서 삭제
					dao.deleteChoanbiota(list.get(idx).getNum()); 
					list = dao.allChoanbiota();
					idx = 0;
					printData();
				}
			}
		});
		
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String specific_name = JOptionPane.showInputDialog(
						null, "조회 할 이름의 일부분을 입력하시오",JOptionPane.QUESTION_MESSAGE);
				tfNum.setText("");
				tfSpecific_name.setText("");
				tfPopulation.setText("");
				tfDetect_day.setText("");
				if(specific_name != null) {
					list = dao.specific_nameChoanbiota(specific_name.trim().toUpperCase());
				    idx = 0;
					printData();
				}
			}
		});
		
		btnClear = new JButton("초기화");
		
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드들의 텍스트를 전부 삭제
				tfNum.setText("");
				tfPopulation.setText("");
				tfSpecific_name.setText("");
				tfDetect_day.setText("");
				// lblIndex 의 타이틀을 삽입으로 변경 
				lblIndex.setText("삽입");
				
			}
			
		});

		lblIndex = new JLabel("", JLabel.CENTER);

		JPanel panel01 = new JPanel();
		panel01.setLayout(new GridLayout(1, 5, 7, 7));
		panel01.setBorder(new TitledBorder("조회"));
		panel01.add(btnFirst);
		panel01.add(btnPrev);
		panel01.add(lblIndex);
		panel01.add(btnNext);
		panel01.add(btnLast);

		JPanel panel02 = new JPanel();
		panel02.setLayout(new GridLayout(1, 5, 7, 7));
		panel02.setBorder(new TitledBorder("작업"));
		panel02.add(btnInsert);
		panel02.add(btnUpdate);
		panel02.add(btnDelete);
		panel02.add(btnSearch);
		panel02.add(btnClear);

		JPanel pa = new JPanel(new BorderLayout());
		pa.add("Center", panel01);
		pa.add("South", panel02);

		add("South", pa);

		setBounds(200, 200, 1200, 1000);
		setTitle("초안산 생물군");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		list = dao.allChoanbiota(); // 셋 비저블 기준으로 앞에 쓰면 바로 보여진다 뒤에 쓰면 나중에 보여진다
		printData();

	}

}
