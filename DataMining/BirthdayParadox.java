package LeetCode.DataMining;

import java.util.HashMap;
import java.util.Random;

public class BirthdayParadox {
	
	Random random;
	HashMap hs;
	
	public int generateRandomNumbers(int n)
	{
		hs = new HashMap<Integer,Integer>();
		random = new Random();
		while(true)
		{
			int temp = random.nextInt(n);
			//System.out.println("The next random integer is "+ temp);
		    if(hs.containsKey(temp))
		    	break;
		    else
		    {
		    	hs.put(temp, 1);
		    }
			
		}
		return hs.size();
	}
	
	
	public static void main(String[] args) {		
		BirthdayParadox bp = new BirthdayParadox();
		int count =0;
		int n= 100;
		String nValues = "";
		String time = "";
		while(n<=1000100)
		{
		long startTime = System.currentTimeMillis();
		count=0;
		while(count<300)
		{
			bp.generateRandomNumbers(n);
			count++;
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		nValues = nValues+n+ ",";
		time = time + elapsedTime +",";
		n = n+10000;
		}
		System.out.println(nValues);
		System.out.println(time);
//		int count=0;
//		int results[] = new int[300];
//		float empericalValue = 0; 
//		
//		while(count < 300)
//		{	
//	    results[count] = bp.generateRandomNumbers(4000);
//	    empericalValue = empericalValue + results[count];
//		count++;
//		}
//		String print="";
//		for(int result: results)
//			print = print + result+ ",";
//		System.out.println(print);
//		System.out.println(empericalValue/300);
		
	}

}
