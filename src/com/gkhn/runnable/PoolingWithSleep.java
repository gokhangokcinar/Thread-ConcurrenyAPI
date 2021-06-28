package com.gkhn.runnable;


public class PoolingWithSleep {

	private static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new Thread(()-> {
			for(int i=0;i<500;i++) PoolingWithSleep.counter++;
		}).start();
		while(PoolingWithSleep.counter<100) {
			System.out.println("Not reached...");
			Thread.sleep(1000);
		}
		System.out.println("Reached!...");
	}

}
