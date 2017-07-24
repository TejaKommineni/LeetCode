package LeetCode.General;

import java.util.Arrays;


public class AllCombinations {

	public static int numbers[];
	
	
	public static void main(String[] args) {
		numbers = new int[6];
		
		for(int i=0;i<6;i++)
		{
			numbers[i]=i+1;
		}
		
		printAllCombinations(6,"");
		
		printPartitions(2, 2, "");
	}

	
	static void printPartitions(int target, int maxValue, String suffix) {
	    if (target == 0)
	        System.out.println(suffix);
	    else {
	        if (maxValue > 1)
	            printPartitions(target, maxValue-1, suffix);
	        if (maxValue <= target)
	            printPartitions(target-maxValue, maxValue, maxValue + " " + suffix);
	    }
	}
	

	private static void printAllCombinations(int i,String print) {
		
		

		for(int a =0;a<numbers.length;a++)
		{
			
			if(i-numbers[a]>=0)
			printAllCombinations(i-numbers[a],print+numbers[a]+" ");
			
		}
		    if(i==0)
			System.out.println(print);
			
		
	}

}
