package LeetCode.DataMining;

import java.util.HashMap;
import java.util.Random;

public class RandomNumbers {
	
	Random random;
	static HashMap<Integer,Integer> hs;
	
	public int generateRandomNumbers(int n)
	{
		
		random = new Random();
		int number =0;
		int j=0;
		while(j<10)
		{			
			number = number<<1;
			int temp = random.nextInt(n);
			System.out.println("The next random integer is "+ temp);
			number = number | temp;			
			j++;
		}
		return number+1;
	}	
	
	public static void main(String[] args) {
		RandomNumbers rd = new RandomNumbers();	
		hs = new HashMap<Integer,Integer>();
		while(hs.size()!=1024)
		{
		 int temp = rd.generateRandomNumbers(2);	
		 if(hs.containsKey(temp))
		    hs.put(temp, hs.get(temp)+1);
		 else
			hs.put(temp, 1); 
		}
		System.out.print(hs);
	}

}
