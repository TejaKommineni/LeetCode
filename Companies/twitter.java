package LeetCode.Trees;
import java.util.Arrays;


public class twitter {


    static int maxLength(int[] a, int k) {
 
        Arrays.sort(a);
        int sum =0;
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            sum = sum+a[i];
            count++;
            if(! (sum<=k))
            {
                sum = sum -a[i];
                count--;
                break;
            }
        }

       return count; 
    }
    
    public int minSubArrayLen(int s, int[] a) {
    	  if (a == null || a.length == 0)
    	    return 0;
    	  
    	  int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
    	  
    	  while (j < a.length) {
    	    sum += a[j++];
    	    
    	    while (sum >= s) {
    	      min = Math.min(min, j - i);
    	      sum -= a[i++];
    	    }
    	  }
    	  
    	  return min == Integer.MAX_VALUE ? 0 : min;
    	}
    public static void main(String[] args) {
		
    	twitter t = new twitter();
    	int a[]={74,659,931,273,545,879,924,710,441,166,493,43,988,504,328,730,841,613,304,170,710,158,561,934,100,279,817,336,98,827,513,268,811,634,980,150,580,822,968,673,394,337,486,746,229,92,195,358,2,154,709,945,669,491,125,197,531,904,723,667,550};
    	t.maxLength(a, 22337);
    	int s[]= {2,3,1,2,4,3};
    	t.minSubArrayLen(7,s);
	}
}
