package com.gkhn.concurrecy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationThreadExecutor {
public static void main(String[] args) throws InterruptedException {
	ExecutorService service =null;
	 try {
		 service = Executors.newSingleThreadExecutor();
		 //add task
	}finally {
		if(service !=null)
			service.shutdown();
	}
	 if(service!=null)
		 service.awaitTermination(1, TimeUnit.MINUTES);
	 if(service.isTerminated()) System.out.println("Finished");
	 else System.out.println("Hala thread çalýþýyor.");
	 
}
}
