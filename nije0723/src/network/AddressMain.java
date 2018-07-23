package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {
		try {
			InetAddress idr = InetAddress.getByName("www.transplant.net"); // 주소 1개 가져오기
			System.out.println(idr);
			System.out.println("=========");
			InetAddress [] ar = InetAddress.getAllByName("www.transplant.net"); // 주소 모두 가져오기
			for(InetAddress imsi : ar) {
				System.out.println(imsi);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
