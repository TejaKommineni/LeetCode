package Contests;

import java.util.ArrayList;

public class Contest29 {
	
	
	 public int longestLine(int[][] M) {
	        
	        if(M.length == 0)
	        return 0;
	        
	        ArrayList<Integer>[][] li = new ArrayList[M.length][M[0].length];
	        int max=0;
	        
	        for(int i=0;i<M.length;i++)
	        {
	            for(int j=0;j<M[0].length;j++)
	            {
	                ArrayList<Integer> sub = new ArrayList<Integer>();
	                int temp =0;
	                if(i-1>=0 && M[i-1][j] ==1)
	                {
	                    temp = li[i-1][j].get(0)+1;
	                    sub.add(temp);
	                    if(temp>max)
	                    max =temp;
	                }
	                else
	                {
	                    if(M[i][j] == 1)
	                    	sub.add(1);
	                    else
	                    	sub.add(0);
	                }
	                
	                if(i-1>=0 && j-1>=0 && M[i-1][j-1] ==1)
	                {
	                    temp = li[i-1][j-1].get(1)+1;
	                    sub.add(temp);
	                    if(temp>max)
	                    max =temp;
	                }
	                else
	                {
	                	 if(M[i][j] == 1)
		                    	sub.add(1);
		                    else
		                    	sub.add(0);
	                }
	                
	                if(j-1>=0 && M[i][j-1] ==1)
	                {
	                    temp = li[i][j-1].get(2)+1;
	                    sub.add(temp);
	                    if(temp>max)
	                    max =temp;
	                }
	                else
	                {
	                	 if(M[i][j] == 1)
		                    	sub.add(1);
		                    else
		                    	sub.add(0);
	                }
	                
	                 if(i-1>=0 && j+1<M[0].length && M[i-1][j+1] ==1)
	                {
	                    temp = li[i-1][j+1].get(3)+1;
	                    sub.add(temp);
	                    if(temp>max)
	                    max =temp;
	                }
	                else
	                {
	                	 if(M[i][j] == 1)
		                    	sub.add(1);
		                    else
		                    	sub.add(0);
	                }
	                 li[i][j] = sub;
	            }
	        }
	        
	        return max;
	    }
	
	public static void main(String[] args) {
		
		Contest29 cs = new Contest29();
		
		int M[][] = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
		
				
				cs.longestLine(M);
		ArrayList<Integer>[][] li = new ArrayList[M.length][M[0].length];
		
	}

}
