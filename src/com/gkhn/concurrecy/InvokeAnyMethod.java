package com.gkhn.concurrecy;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyMethod {

	//Tasklarýn ilk baþarýyla biteni döndürür. Digerlerini öldürür.
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			Callable<String> task = () -> "result";
			String data = service.invokeAny(List.of(task,task,task));
			System.out.println(data);
			System.out.println("end");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
