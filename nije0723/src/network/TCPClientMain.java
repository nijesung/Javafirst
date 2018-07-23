package network;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientMain {

	public static void main(String[] args) {
		try {
			
		InetAddress adr = InetAddress.getByName("192.168.0.238");
		Socket socket = new Socket(adr, 9996); // 서버에 접속
		
		Scanner sc = new Scanner(System.in);
		System.out.println("pushing message: ");
		String msg = sc.nextLine();
		sc.close();
		
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream()); // 전송할 스트림 생성
		
		pw.println(msg); // 데이터 전송
		pw.flush();
		
		socket.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
