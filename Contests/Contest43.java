package LeetCode.Contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Contest43 {
	
	 public void minmax(int[]x, String[] op)
	 {
		 int min = Integer.MAX_VALUE;
		 int max = Integer.MIN_VALUE;
		 TreeSet<Integer> hs = new TreeSet();
		 long ans =0;
		 for(int i=0;i<op.length;i++)
		 {
			 if("push".equals(op[i])) {
			 if(!hs.contains(x[i]))
			 {	
				 hs.add(x[i]);
				 if(hs.size() == 1)
				 {
					 min = x[i];
					 max =x[i];
				 }
				 else if(x[i] >max)
					 max = x[i];
				 else if(x[i]<min)
					 min =x[i];
				 
				
				 
			 }
			 ans =min*max;
		 }}
	 }
	
	 static long maxPoints(int[] elements) {
	        
	        TreeMap<Integer, Integer> hs = new TreeMap();        
	        
	        for(int i=0;i<elements.length;i++)
	        {
	            hs.put(elements[i], hs.getOrDefault(elements[i],0)+1);
	        }
	        long prevNo =0;
	        long prevYes =0;
	        for(Map.Entry<Integer,Integer> e: hs.entrySet())
	        {
	            long temp = prevNo;
	            prevNo = Math.max(prevNo, prevYes);
	            prevYes = e.getKey()*e.getValue() +temp;
	        }
	      
	        return Math.max(prevNo, prevYes);

	    }
	
	
	public static void main(String[] args) throws IOException {
		Contest43 cs = new Contest43();
		cs.maxPoints(new int[] {3,2,4});
		cs.minmax( new int[] {2,2,2}, new String[] {"push","push","pop"});
		
		
		
		
		
		
		
		
		
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null) {
	      
	      String splited[] = s.split(",");
	      int k=0;
	      char [][] board = new char[9][9];
	      for(int i=0;i<board.length;i++)
	      {
	          for(int j=0;j<board[0].length;j++)
	          {
	              board[i][j] = splited[k++].charAt(0);
	          }
	      }
	      boolean flag = true;
	      for(int i=0;i<board.length;i++)
	      {
	          boolean[] m = new boolean[9];
	          for(int j=0;j<board[0].length;j++)
	          {
	              if(m[(int) (board[i][j] - '1')])
	              {
	                  flag = false;
	                  break;
	              }
	              m[(int) (board[i][j] - '1')] = true;
	          }
	          if(flag == false)
	            break;
	      }
	      
	      if(flag == true)
	      {
	          for(int j=0;j<board[0].length;j++)
	          {
	              boolean[] m = new boolean[9];
	                  for(int i=0;i<board.length;i++)
	                {
	                     if(m[(int) (board[i][j] - '1')])
	                     {
	                          flag = false;
	                          break;
	                     }
	                     m[(int) (board[i][j] - '1')] = true;
	                    
	                }
	                  if(flag == false)
	                    break;
	          }      
	          
	      }
	      
	      if(flag == true)
	      {
	           for( int b=0;b<9;b++)
	           {
	                boolean[] m = new boolean[9];
	                for(int i=b/3*3;i<b/3*3+3 ; i++)
	                {
	                    for(int j = b%3*3;j<b%3*3+3;j++)
	                    {
	                         if(m[(int) (board[i][j] - '1')])
	                             {
	                                  flag = false;
	                                  break;
	                             }
	                             m[(int) (board[i][j] - '1')] = true;
	                        
	                    }
	                    if(flag == false)
	                    break;
	                    
	                }
	                 if(flag == false)
	                    break;
	               
	           }
	    
	      }      
	      
	      if(!flag)
	         System.out.println("False");
	      else
	       System.out.println("True");
	      
	    }
	    
		
	}
}
