
class MyThread implements Runnable{

	Thread t;
	
	MyThread(String threadName)
	{
	  t = new Thread(this,threadName); 
	  System.out.println("New thread: " + t);
	  t.start();
	}
	
	@Override
	public void run() {
		
		try {
			for(int i = 5; i > 0; i--) {
			System.out.println("Child Thread: " + this.t + i);
			Thread.sleep(100);
			}
			} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
			}
			System.out.println("Exiting child thread.");
			
	
	}
}
public class MultipleThreads
{
	public static void main(String[] args) {
		
		new MyThread("First Thread");
		new MyThread("Second Thread");
		new MyThread("Third Thread");
		System.out.println("Exiting Main thread.");
		
		Integer i=300;
		int k = i;
		
	}

	
}
