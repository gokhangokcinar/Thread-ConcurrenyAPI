package com.gkhn.concurrecy;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceSimple {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			Runnable task1 =() -> System.out.println("Merhaba");
			Callable<String> task2 =() ->"Selam";
			Runnable task3 =() -> System.out.println("Hi");;
			ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS); // 10 sn sonrasýna programlanýr.
			ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES); // 8 dk sonrasýna programlanýr.
			service.scheduleAtFixedRate(task3, 5, 1, TimeUnit.MINUTES); //Ýlk 5 dklýk gecikmenin ardýndan her dk çalýþtýrýlýr.
			service.scheduleWithFixedDelay(task3, 0, 2, TimeUnit.MINUTES); //Önceki görevin tamamlanmasýný bekler, 2 dakikalýk gecikme sonrasý her dk çalýþýr.
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
