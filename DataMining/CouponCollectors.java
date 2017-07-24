package LeetCode.DataMining;

import java.util.HashMap;
import java.util.Random;

public class CouponCollectors {
	
	Random random;
	HashMap<Integer,Integer> hs;
	
	public int generateRandomNumbers(int n)
	{
		hs = new HashMap<Integer,Integer>();
		random = new Random();
		int numberOfTrials = 0;
		while(true)
		{
			numberOfTrials++;
			if(hs.size()==n)
				break;
			int temp = random.nextInt(n);
			//System.out.println("The next random integer is "+ temp);
		    if(hs.containsKey(temp))
		    {
		    	hs.put(temp, hs.get(temp)+1);
		    }
		    else
		    {
		    	hs.put(temp, 1);
		    }
			
		}
		return numberOfTrials;
	}
	
	public static void main(String[] args) {
		
		CouponCollectors cc = new CouponCollectors();
		
		int count =0;
		int n= 20;
		String nValues = "";
		String time = "";
		while(n<=20000)
		{
		long startTime = System.currentTimeMillis();
		count=0;
		while(count<3000)
		{
			cc.generateRandomNumbers(n);
			count++;
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		nValues = nValues+n+ ",";
		time = time + elapsedTime +",";
		n = n*10;
		}
		System.out.println(nValues);
		System.out.println(time);
//		int count=0;
//		int results[] = new int[300];
//		float empericalValue = 0; 
//		while(count < 300)
//		{	
//	    results[count] = cc.generateRandomNumbers(200);
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
