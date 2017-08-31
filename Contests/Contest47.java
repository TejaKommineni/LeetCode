package LeetCode.Contests;

import java.util.HashSet;

public class Contest47 {

	 public int pathSum(int[] nums) {
	        if(nums == null || nums.length == 0)
	            return 0;
	        HashSet<Integer> visited = new HashSet();
	        return dfs(nums,0,visited,0);
	    }
	    public int dfs(int[] nums, int start, HashSet<Integer> visited,int temp)
	    {
	        if(start >= nums.length || visited.contains(nums[start]))
	            return 0;
	        
	        int sum = 0;
	        visited.add(nums[start]);
	        int count =0;
	        for(int i=start+1;i<nums.length;i++)
	        {
	            int a = nums[i]/100;
	            int b = nums[start]/100;
	            int c = (nums[i]/10)%10;
	            int d = (nums[start]/10)%10;
	            if(a == b +1 && ((c-1)/2 +1) == d)
	            {        
	                sum = sum + dfs(nums,i,visited,temp+nums[start]%10);
	                count ++;
	            }
	        }
	        
	        return count==0? temp+nums[start]%10:sum;
	    }
	    
	    public static void main(String[] args) {
			
	    	Contest47 cs = new Contest47();
	    	System.out.println(cs.pathSum(new int[]{113,229,349,470,485}));
		}
}
