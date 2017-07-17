package Misscelanious;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	
	public String largestNumber(int[] nums) {
	    String[] arr = new String[nums.length];
	    for(int i=0; i<nums.length; i++){
	        arr[i]=String.valueOf(nums[i]);
	    }
	 
	    Arrays.sort(arr, new Comparator<String>(){
	        public int compare(String a, String b){
	            return (b+a).compareTo(a+b);
	        }
	    });
	 
	    StringBuilder sb = new StringBuilder();
	    for(String s: arr){
	        sb.append(s);
	    }
	 
	    while(sb.charAt(0)=='0'&&sb.length()>1)
	        sb.deleteCharAt(0);
	 
	    return sb.toString();
	}
	
	public int findCircleNum(int[][] M) {
        
		boolean visited [] = new boolean[M.length];
		
		int count =0;
 		for(int i=0;i<M.length;i++)
		{
 			    
			    visited[i] = true;
				dfs(M,i,visited);				
				int temp =0;
				for(int k=0;k<M.length;k++)
				{
				    if(visited[k]==false)
				    break;
				    
				    temp++;
				}
				if(temp == M.length)
				break;
		}
		        
        return count;
    }

	private void dfs(int[][] m, int i, boolean[] visited) {
		
		for(int j=0;j<m[i].length;j++)
		{
			if( i!=j && m[i][j] == 1)
				visited[j] = true;
			
			for(int k=0;k<m[j].length;k++)
			{
				if(k!=j && m[j][k] == 1)
					visited[k] = true;
			}	
			
		}		
	}

	 private static void main2() throws IOException {
		    int n = 6, j = 3;
		    char[] s1 = new char[n];
		    Arrays.fill(s1, '0');
		    s1[n-1] = '1';
		    s1[n/2-1] = '1';
		    BigInteger[] mult = new BigInteger[11];
		    for (int i = 2; i <= 10; i++) {
		      mult[i] = new BigInteger(new String(s1), i);
		    }
		    char[] s2 = new char[n];
		    Arrays.fill(s2, '0');
		    s2[n/2] = '1';
		    BigInteger a1 = mult[2];
		    int count = 0;
		    for (int i = 1; count < j; i += 2) {
		      BigInteger add = new BigInteger(new String(s2), 2);
		      add = add.add(new BigInteger(""+i));
		      BigInteger result = add.multiply(a1);
		      System.out.print(result.toString(2));
		      for (int k = 2; k <= 10; k++) System.out.print(" "+mult[k]);
		      count++;
		      System.out.println();
		    }
		  }
	
	
	public static void main(String[] args) throws IOException {
		
		LargestNumber ln = new LargestNumber();
		String s = "Vathsala";
		System.out.println(s.replaceAll("a", ""));
		
		int nums[] = {3, 30, 34, 5, 9};
				ln.largestNumber(nums);
				
		int[][] friends = {{1,1,0},{1,1,0},{0,0,1}}	;	
		ln.findCircleNum(friends);
		ln.main2();
		System.out.println(ln.cookies(189.00000, 2.00000, 378.00000));
		}

	private double cookies(double C, double F, double X) {

		double time = 0; double curr =2.0;
		
		while(true)
		{
		if(X/curr + time < (X/(curr+F)) +(time)+(C/curr))
		{
			break;
		}
		else
		{	
			time = time+C/curr;
			curr = curr+F;
		}
		
			
		}
		return time+X/curr;
	} 
	
}
