import java.util.Arrays;


public class TicketBooking {

	public static void main(String[] args) {

		Train T = new Train("Shatabdi",40,2);
		reserveTicket r = new reserveTicket(T);
		cancelTicket c = new cancelTicket(T);
		
		Thread t = new Thread(r);
		Thread t1 = new Thread(c);
		
		for(int i=0;i<10;i++)
		{
		new Thread(r).start();
		new Thread(c).start();
		}
	}
	
	
}

class reserveTicket implements Runnable
{	

	Train train;
	compartment compartment;
	public reserveTicket(Train t) {
		train=t;
		compartment=train.getCompartments()[0];
	}

	@Override
	public void run() {
	
		synchronized(train)
		{
			train.reserveSeat();
			synchronized(compartment)
			{
			  compartment.reserveSeat();
			}  
		}
		
	}

}

class cancelTicket implements Runnable
{
	Train train;
	compartment c;
	public cancelTicket(Train t) {
		train = t;
		c =t.getCompartments()[0];
	}

	@Override
	public void run() {

		synchronized(c)
		{
			c.unreserveSeat();
			synchronized(train)
			{
			 train.unreserveSeat();
			}
		}
						
	}

}

class compartment
{
 String seats[];
 Train train;
 compartment(Train train,int s)
 {
	 this.train = train;
	 seats = new String[s];
	 Arrays.fill(seats, "available");
 }
 
 public void reserveSeat()
 {
	 seats[0]="Reserved";
	 System.out.println("In compartment : seat Reserved");
 }
 
 public void unreserveSeat()
 {
	 seats[0]="available";	 
	 train.unreserveSeat();
	 System.out.println("In compartment : seat unreserved");
 }
 
	
}

class Train
{
	String trainName;
	int numberOfSeatsAvailable;
	int numberOfCompartments;
	compartment compartments[]; 
	Train(String t, int s,int c)
	{
		trainName = t;
		numberOfSeatsAvailable=s;
		numberOfCompartments=c;
		compartments = new compartment[numberOfCompartments];
		for(int i=0;i<numberOfCompartments;i++)
		{
			compartments[i] = new compartment(this,(s/c)+1); 
		}
		
	}
	
	
	public int getNumberOfCompartments() {
		return numberOfCompartments;
	}
	public void setNumberOfCompartments(int numberOfCompartments) {
		this.numberOfCompartments = numberOfCompartments;
	}
	public compartment[] getCompartments() {
		return compartments;
	}
	public void setCompartments(compartment[] compartments) {
		this.compartments = compartments;
	}
	
	public int getNumberOfSeatsAvailable() {
		return numberOfSeatsAvailable;
	}
	public void setNumberOfSeatsAvailable(int numberOfSeatsAvailable) {
		this.numberOfSeatsAvailable = numberOfSeatsAvailable;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	 public void reserveSeat()
	 {
		 numberOfSeatsAvailable--;
		 System.out.println("In train : seat Reserved");
		 
	 }
	 
	 public void unreserveSeat()
	 {
		 numberOfSeatsAvailable++;	 
		 System.out.println("In train : seat unreserved");
		
	 }
	 	
	
}