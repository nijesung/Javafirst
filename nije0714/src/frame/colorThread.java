package frame;

import java.awt.Button;
import java.awt.Color;

public class colorThread extends Thread {
	
	private Button button;
	
	public colorThread(Button button) {
		this.button = button;
	}
	
	public void run() {
		/*
		Color[] color = {
				color.
				color.blue,
				color.green
		};
		*/
		/*
		int idx = 0;
		while(true) {
			try {
				idx = idx+1;
				button.setBackground(color[idx % color.length]);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		
	}
	

}
