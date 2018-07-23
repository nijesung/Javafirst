package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			
			Scanner sc = new Scanner(System.in);
					System.out.println("send Massage: ");
			
					String msg = sc.nextLine();
			
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, 
					InetAddress.getByName("192.169.0.100"),5000);
			ds.send(dp);
			
			sc.close();
			ds.close();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
