package java8.module1.lambda;

import java.util.Date;

public class LambdaDigitalClock {

	public static void main(String[] args) {
	
		//Using nested Anonymous class ...
		Thread t = new Thread(new Runnable(){
			public void run(){
				runClock();
			}
		});
		
		//t.start();		
		//Using Lambda expression
		Thread t2 = new Thread(()->runClock());
		t2.start();
	}
	
	//Method to print Time HH:MM:SS after 1 seconds delay
	static void runClock(){
		while(true){
			Date d = new Date();
			System.out.printf("\r%s",d.toString().substring(11,20));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){}
		}
	}

}
