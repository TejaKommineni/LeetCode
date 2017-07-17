
public class assf {
	
	
	static void arrangeCoins(long[] coins) {
		  
	      for(int i=0;i<coins.length;i++)
	       {
	        long low=1;
	        long high=coins[i];
	        long mid;
	        boolean flag= false;
	        while(low<high)
	        {
	         mid = (low+high)/2;   
	         long sum= (mid*(mid+1))/2;
	         if(sum == coins[i])
	          {
	          System.out.println(mid); 
	          flag= true;
	          break;
	          }
	          if(sum <coins[i])  
	           {
	             low=mid+1; 
	           }
	           if(sum >coins[i])  
	           {
	              high=mid-1;
	           } 
	        }
	        if(!flag)
	        {	
	        	long sum= (low*(low+1))/2;	
	            if(sum<coins[i])
	             System.out.println(low);	
	            else
	             System.out.println(low-1);	
	        	
	        }
	      }  
	    }
	
	public static void main(String[] args) {
		
		long coins[]= {2,5,8,3};
		arrangeCoins(coins);
	}

}
