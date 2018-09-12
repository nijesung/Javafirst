package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

import sun.net.www.protocol.http.HttpURLConnection;

public class EtcServiceImpl implements EtcService {
	private EtcServiceImpl() {}
	
	private static EtcService etcService;
	
	public static EtcService sharedInstance() {
		if(etcService == null) {
			etcService = new EtcServiceImpl();
		}
		return etcService;
	}

	@Override
	public boolean mailSend(HttpServletRequest request) {
		// 네트워크를 사용하면 예외처리가 필수다
		boolean result = false;
		try {
			request.setCharacterEncoding("utf-8");
			// 파라미터 읽기
			String receiver = request.getParameter("receiver");
			String subject = request.getParameter("subject");
			String msg = request.getParameter("msg");
			
			SimpleEmail email = new SimpleEmail();
			
			// 메일 서버 설정
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			
			// 메일을 암호화 해서 전송하기 위한 설정
			email.setSSLOnConnect(true);
			email.setStartTLSEnabled(true);
			
			// 인코딩 설정
			email.setCharset("utf-8");
			
			// 피폭자와 제목 및 내용 설정
		    email.setMsg(msg);
		    email.setSubject(subject);
		    email.addTo(receiver);
		    
		    // 보내는 사람 설정
		    email.setAuthentication("ggangpae3", "qkranstjr");
		    email.setFrom("ggangpae3@naver.com", "피폭자", "utf-8");
		    
		    // 메일 보내기
		    email.send();
		    result = true;
		    
		    
		    
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public String proxy(HttpServletRequest request) {
		String result = "";
		
		try {
			// 다운로드 받을 주소를 문자열로 생성
			String addr = "http://www.weather.go.kr/weather/forecast/mid-term-xml.jsp?stnId=109";
			
			// URL 로 변환
			// 한글이나 특수문자가 있으면 인코딩을 해야 한다.
			// java.net.URLEncoder.encode(url, 인코딩방식)
			URL url = new URL(addr);
			
			// URL Connection 객체 만들기
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// 옵션 설정
			// 이 시간동안 다운로드 받지 못하면 연결 해제
			con.setConnectTimeout(30000);
			
			// 항상 새로운 데이터를 가져오도록 설정
			con.setUseCaches(false);
			
			// 문자열을 다운로드 받을 수 있는 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			// 문자열을 복사하지 않고 추가할 수 있는 클래스의 인스턴스 생성
			StringBuilder sb = new StringBuilder();
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line);
			}
			// StringBuilder 는 여분의 공간을 가지기 때문에 수정하지 않을 거라면 메모리 낭비가 된다.
			result = sb.toString();
			br.close();
			con.disconnect();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void push(HttpServletRequest request, HttpServletResponse response) {
		// 출력을 위한 스트림 생성
		PrintWriter pw = null;
		
		try {
			// 출력형식을 text/event-stream 으로 설정
			response.setContentType("text/event-stream");
			// 출력 인코딩 설정
			response.setCharacterEncoding("utf-8");
			// 출력 내용을 만들고 출력하기
			pw = response.getWriter();
			Random r = new Random();
			pw.write("data: " + (r.nextInt(45)+1) + "\n\n");
			// 3초 대기
			Thread.sleep(3000);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}finally {
			if(pw != null)
				pw.close();
		}
	}

}
