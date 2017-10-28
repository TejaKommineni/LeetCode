package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

/*Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
	     
	     List<List<Integer>> li = new ArrayList();
	     
	    if(numRows ==0 ) return li; 
	     
	     int n=1;
	     
	         while(n<=numRows)
	         {
	             List<Integer> sub = new ArrayList();
	             
	             if(n == 1)
	                sub.add(1);    
	             else if(n == 2)
	                 {
	                  sub.add(1);
	                  sub.add(1);  
	         
	                 }
	             else
	             {
	             
	                 sub.add(1);
	                 for(int i=1;i<li.get(n-2).size();i++)
	                 { sub.add((li.get(n-2).get(i)) + (li.get(n-2).get(i-1)));}
	                 sub.add(1);
	                 
	             }    
	             n++;               
	             li.add(sub);
	         }
	     
			return li;
	 }

}
