package com.gkhn.concurrecy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SubmitMethodExecutorService2  {
private static int counter = 0;
public static void main(String[] args) throws Exception{
	ExecutorService service = null;
	try {
		service = Executors.newSingleThreadExecutor();
		Future<Integer> result = service.submit(()->30+11);
		System.out.println(result.get());
		
	}
	finally {
		if(service!=null) service.shutdown();
	}
}
}
