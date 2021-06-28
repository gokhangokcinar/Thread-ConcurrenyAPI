package com.gkhn.concurrecy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSimple {
	public static void main(String[] args) {
		ExecutorService service = null;
		Runnable task1 = () -> System.out.println("Hello world");
		Runnable task2 = () -> {for(int i=0;i<3;i++)
			System.out.println("Yaz: "+i)
			;};
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("baþla");
			service.execute(task1);
			service.execute(task2);
			service.execute(task1);
			System.out.println("bitti");
		}finally {
			if(service!=null) service.shutdown();
		}
	}

}
