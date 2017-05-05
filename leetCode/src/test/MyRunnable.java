package test;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("run");

	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.err.println(Thread.currentThread().getName()+"-"+this.hashCode()+"-finalize");
	}

}
