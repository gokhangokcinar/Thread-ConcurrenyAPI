package com.gkhn.concurrecy.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService service = null;
		Runnable task1 = () -> System.out.println("Hello world");
		Runnable task2 = () -> {for(int i=0;i<3;i++)
			System.out.println("Yaz: "+i)
			;};
		try {
			service = Executors.newFixedThreadPool(3); // 3 Threadlik havuzdan tahsis ettik tasklar için. 3 thread dolarsa tasklarýn bitmesi beklenir. 1 yazsaydýk single gibi çalýþacaktý.
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
