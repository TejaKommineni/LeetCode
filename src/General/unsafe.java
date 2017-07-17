class Tickets
{
int count=100;	

public void getTicket()
{
	System.out.println("Hi, I am thread "+Thread.currentThread() + "The seat reserved is"+count--);
}


}

class DeadLocks implements Runnable {

	int shared =50;
	Tickets ticket;
	public DeadLocks(Tickets ticket) {
		this.ticket = ticket;
	}

	@Override
	public void run() {
	synchronized(ticket){	
	ticket.getTicket();
	}
	
  }
		
    public synchronized void ticket()
    {
    	if(shared>0)
		{	
			System.out.println("Hi, I am thread "+Thread.currentThread() + "The seat reserved is"+shared--);
		}
		else
		{
			System.out.println("Hi, I am thread "+Thread.currentThread()+ "There are no seats available" );
		}
    }

	
}

public class unsafe {
	
public static void main(String[] args) {

	Tickets ticket = new Tickets();
	DeadLocks d = new DeadLocks(ticket);
	Thread t1 = new Thread(d);
	Thread t2 = new Thread(d);
	for(int i=0;i<50;i++)
	{
	   new Thread(d).start();
	   new Thread(d).start();
	}
		
  }
}
