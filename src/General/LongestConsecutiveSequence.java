import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class LongestConsecutiveSequence {

	static int dp[][];
	
	public int LongestConsecutiveSequence(int nums[])
	{
		Set<Integer> set = new TreeSet<Integer>();
		String s;
	
		for(int i=0;i<nums.length;i++)
		{
			set.add(nums[i]);
		}
		
		Object arr[] = set.toArray(); 
		int max= 1;
		int localMax=1;
		for(int i=1;i<arr.length;i++)
		{
			if((int)arr[i]-(int)arr[i-1] == 1)
			{
				localMax++;
			}
			else
			{			
				max = Math.max(max, localMax);
				localMax =1;
			}
			
		}
		max = Math.max(max, localMax);
		return max;
		
	}
	
	int digitSquareSum(int n) {
	    int sum = 0, tmp;
	    while (n>0) {
	        tmp = n % 10;
	        sum += tmp * tmp;
	        n /= 10;
	    }
	    return sum;
	}

	boolean isHappy(int n) {
	    int slow, fast;
	    slow = fast = n;
	    do {
	        slow = digitSquareSum(slow);
	        fast = digitSquareSum(fast);
	        fast = digitSquareSum(fast);
	    } while(slow != fast);
	    if (slow == 1) return true;
	    else return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println((double)1/6);
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		lcs.isHappy(20);		
		int nums[]={0,-1};
		lcs.LongestConsecutiveSequence(nums);
		
	}
	
	
}
