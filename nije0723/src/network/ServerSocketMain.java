package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {

	public static void main(String[] args) {
		try {
			
			ServerSocket ss = new ServerSocket(9996); // 서버 소켓 생성
			while(true) {
				System.out.println("server waiting.......");
				Socket socket = ss.accept(); // 클라이언트 접속 대기 - 클라이언트가 접속하면 클라이언트와의 통신을 위한
				                             // Socket 을 리턴하고 다음 줄의 코드 실행
				
				BufferedReader br = new BufferedReader // 한 줄의 데이터를 읽고 출력
						(new InputStreamReader(socket.getInputStream()));
				
				String msg = br.readLine();
				System.out.println("message: " + msg);
				System.out.println("connecter: " + socket.getInetAddress());
				br.close();
				socket.close();
				
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
