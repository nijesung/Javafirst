package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer01 {

	public static void main(String[] args) {
		//UDP 전송을 받는 곳
		
		try {
			DatagramSocket ds = new DatagramSocket(666);
			
			while(true) {
				byte [] b = new byte[1024]; // 데이터를 저장할 배열을 생성
				
				DatagramPacket dp = new DatagramPacket(b, 1024); // DatagramPacket 생성
				
				ds.receive(dp); // 데이터 받기
				
				String msg = new String(b, 0, 1024); // 데이터를 읽고 출력
				System.out.println("send local: " + dp.getAddress());
				System.out.println("message" +msg);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
