package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnableThreadPool {

	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(1500);
		ExecutorService exe =  Executors.newFixedThreadPool(30);
		for (int i = 0; i < 30; i++) {
			exe.execute(new MyRunnable());
		}
		//System.gc();
		System.out.println("end");
	}
}
