import java.util.HashMap;

public class NumberOfBits {
	public int numSetBits(long a) {
	    
	    int track=0;
	    int bits = 0;
	    for(int i=0;i<=32;i++)
	    {
	        double power=Math.pow(2,i);
	        if(a<power)
	        {
	            track=i-1;
	            break;
	        }
	        if(a==power)
	        {
	            track=i;
	            break;
	        }
	    }
	    
	    if(track==-1)
	      return 0;
	    else
	    {
	    	double number=a;
	       
	       for(int i=track;i>=0;i--)
	        {
	           if(number>0)
	           {
	        	   number=number-Math.pow(2,i);
	        	   bits=bits+1;
	               if(number<0)
	               {
	            	   number=number+Math.pow(2, i);
	            	   bits=bits-1;
	               }
	        	  
	               
	           }
	          
	            
	        }
	    }
	    
	    
	    System.out.println(bits);
	    return bits;
	    
	}
	
	public static void main(String[] args) {
		
		NumberOfBits nb = new NumberOfBits();
		nb.numSetBits(3);
		
		HashMap li = new HashMap();
		
		
	}
}
