package LeetCode.Arrays;

import java.util.HashMap;

public class SubArraySum {

	 public int subarraySum(int[] nums, int k) {
	        int count =0;
	        if(nums.length == 1 && nums[0] == k)
	            count++;
	        HashMap<Integer,Integer>  hs = new HashMap();
	        hs.put(0,1);
	        hs.put(nums[0], 1);
	        for(int i=1;i<nums.length;i++)
	        {
	            nums[i] = nums[i]+nums[i-1];
	            if(hs.containsKey(nums[i]-k))
	                count = count+hs.get(nums[i]-k);
	            if(hs.containsKey(nums[i]))
	                hs.put(nums[i],hs.get(nums[i])+1);
	            else
	                hs.put(nums[i],1);
	                
	        }
	      return count;   
	    }
	 
	 public static void main(String[] args) {
		 
		 SubArraySum s = new SubArraySum();
		 s.subarraySum(new int[] {1,1,1}, 2);
		
	} 
	 
}
