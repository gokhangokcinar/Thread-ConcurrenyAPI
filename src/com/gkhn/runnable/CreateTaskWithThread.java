package com.gkhn.runnable;

public class CreateTaskWithThread extends Thread{
 @Override
public void run() {
	System.out.println("Merhaba Dünya");
}
 public static void main(String[] args) {
	(new CreateTaskWithThread()).start();
}
}
