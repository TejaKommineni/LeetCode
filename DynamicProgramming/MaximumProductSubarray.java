package LeetCode.DynamicProgramming;

public class MaximumProductSubarray {
	 public int maxProduct(int[] nums) {
	        
	        if(nums.length == 0)
	        return 0;
	        if(nums.length == 1)
	        return nums[0];
	        int maxProduct =Integer.MIN_VALUE;
	        int temp = 0;
	        int local = 1;
	        
	        for(int i=0;i<nums.length;i++)
	        {
	              if(nums[i] == 0)
	              {
	            	  maxProduct = Math.max(maxProduct, 0);
	                  temp =0;
	                  local =1;
	                  continue;
	              }
	              if(local * nums[i]<0)
	              {
	                  if(temp != 0)
	                  {
	                      maxProduct = Math.max(maxProduct, temp*nums[i]);
	                      temp=0;
	                      local =maxProduct;
	                  }
	                  else
	                  {
	                      temp = local * nums[i];
	                      local =1;
	                  }
	              }
	              else
	              {
	               local = local *nums[i];
	               maxProduct = Math.max(maxProduct, local); 
	               if(temp != 0)
	                temp = temp *nums[i];
	              }
	        }
	        return maxProduct;
	    }
	 
	 public static void main(String[] args) {
		 MaximumProductSubarray mp = new MaximumProductSubarray();
		 int nums[] = {-2,-3,7};
		 mp.maxProduct(nums);
		
	}

}
