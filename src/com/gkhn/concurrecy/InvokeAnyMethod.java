package com.gkhn.concurrecy;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyMethod {

	//Tasklar�n ilk ba�ar�yla biteni d�nd�r�r. Digerlerini �ld�r�r.
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
