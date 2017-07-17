import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public void setZeroes(ArrayList<List<Integer>> a) {
	    
	    
		for(int i=1;i<1;i++)
			System.out.println("teja");
		
	    for(int i=0;i<a.size();i++)
	    {
	        for(int j=0;j<a.get(i).size();j++)
	        {
	            
	            if(a.get(i).get(j)==0)
	            {
	                
	                for(int k=0;k<a.get(i).size();k++)
	                {
	                 a.get(i).set(k, 2);
	                }
	                 
	                for(int k=0;k<a.size();k++)
	                {
	                 a.get(k).set(j,2);   
	                }
	                
	            }
	            
	        }
	    }
	            
	    for(int i=0;i<a.size();i++)
	    {
	        for(int j=0;j<a.get(i).size();j++)
	        {
	         
	          if(a.get(i).get(j)==2)
	            {
	                a.get(i).set(j,0);
	                
	            }
	            
	        }
	    }
	      
	        
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		
		
		
		ArrayList<List<Integer>> a= new ArrayList<List<Integer>>();
		List<Integer> x =Arrays.asList(0,0);
	a.add(x);
	x =Arrays.asList(1,0);
	a.add(x);
		
		s.setZeroes(a);
	}
	
}
