package com.gkhn.runnable;

public class CreateTaskWithRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<3;i++)
			System.out.println("Yaz: "+i);
	}
	
	public static void main(String[] args) {
		(new Thread(new CreateTaskWithRunnable())).start();
	}

}
