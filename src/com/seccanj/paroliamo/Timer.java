package com.seccanj.paroliamo;
import java.awt.Toolkit;

public class Timer {

	public static void main(String[] args) throws InterruptedException {
		
		for (int i=0; i<3; i++) {
			Thread.sleep(60000);
			
			Toolkit tk = Toolkit.getDefaultToolkit();
		    tk.beep();
		    
		    System.out.println(i+1);
		}
	}
	
}
