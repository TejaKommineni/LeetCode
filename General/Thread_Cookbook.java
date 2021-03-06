package LeetCode.General;
import java.lang.Thread.State;


class Thread_Implementation implements Runnable{

	private int number;
	public Thread_Implementation(int number) {
	this.number=number;
	String s = new String();
	s.contains("teja");
	}
	
	@Override
	public void run() {
		
		for (int i=1; i<=10; i++){
			System.out.printf("%s: %d * %d = %d\n",Thread.
			currentThread().getName(),number,i,i*number);
			}
		
		
	}
}
	
	public class Thread_Cookbook {
		public static void main(String[] args) {
			Thread threads[]=new Thread[10];
			Thread.State status[]=new Thread.State[10];
			
			for (int i=0; i<10; i++){
				threads[i]=new Thread(new Thread_Implementation(i));
				if ((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
				} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
				}
				threads[i].setName("Thread "+i);
				}
			
			for (int i=0; i<10; i++){
				System.out.println("Main : Status of Thread "+i+" : " +
				threads[i].getState());
				status[i]=threads[i].getState();
				}
			
			for (int i=0; i<10; i++){
				threads[i].start();
				}
			
			boolean finish=false;
			while (!finish) {
			for (int i=0; i<10; i++){
			if (threads[i].getState()!=status[i]) {
			writeThreadInfo(threads[i],status[i]);
			status[i]=threads[i].getState();
			}
			}
			finish=true;
			for (int i=0; i<10; i++){
			finish=finish &&(threads[i].getState()==State.TERMINATED);
			}
			}
			
			
		}
		
		private static void writeThreadInfo(Thread
				thread, State state) {
				System.out.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
				System.out.printf("Main : Priority: %d\n",thread.getPriority());
				System.out.printf("Main : Old State: %s\n",state);
				System.out.printf("Main : New State: %s\n",thread.getState());
				System.out.printf("Main : ************************************\n");
				}

	}	

	
	