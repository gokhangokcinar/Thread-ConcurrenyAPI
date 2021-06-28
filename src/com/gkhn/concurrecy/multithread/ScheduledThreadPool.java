package com.gkhn.concurrecy.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(2); //Singleschedule ile ayn� mant�k. Burda sadece thread havuzu mant��� var. Ne kadarl�k bir thread havuzu olu�turaca��m�z� belirtiyoruz..
			Runnable task1 =() -> System.out.println("Merhaba");
			Callable<String> task2 =() ->"Selam";
			Runnable task3 =() -> System.out.println("Hi");;
			ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS); // 10 sn sonras�na programlan�r.
			ScheduledFuture<?> r2 = service.schedule(task2, 8, TimeUnit.MINUTES); // 8 dk sonras�na programlan�r.
			service.scheduleAtFixedRate(task3, 5, 1, TimeUnit.MINUTES); //�lk 5 dkl�k gecikmenin ard�ndan her dk �al��t�r�l�r.
			service.scheduleWithFixedDelay(task3, 0, 2, TimeUnit.MINUTES); //�nceki g�revin tamamlanmas�n� bekler, 2 dakikal�k gecikme sonras� her dk �al���r.
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
