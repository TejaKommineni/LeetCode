import java.util.ArrayList;


public class GoogleAverageAdjacent {
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("The Maximum number after adjacent average is"+ averageAdjacent(9817));
	}

	private static int averageAdjacent(int n) {
		
		ArrayList<Integer> digits =new ArrayList<Integer>();
		int maximum = Integer.MIN_VALUE;
		
		while(n>0)
		{
			digits.add(n%10);
			n=n/10;
		}
		
		for(int i=digits.size()-1;i>0;i--)
		{
		int average =(int) Math.ceil((digits.get(i)+digits.get(i-1))/2.0);
		
		int number = 0;	
		int count=0;
		int j=0;
		for(;j<i-1;j++)
		{
		number=(int) (number+ digits.get(j)*Math.pow(10, count));	
		count++;
		}
		number=(int) (number+ average*Math.pow(10, count));
		j++;
		j++;
		count++;
		for(;j<digits.size();j++)
		{
		number=(int) (number+ digits.get(j)*Math.pow(10, count));	
		count++;
		}
		
		if(number>maximum)
			maximum=number;
		
		}			
		return maximum;
		
	}
	

}
