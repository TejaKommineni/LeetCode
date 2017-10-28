package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	/*
	 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is:
[
  [7],
  [2, 2, 3]
]
	 * 
	 */
	

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     
        List<List<Integer>> li = new ArrayList();
        List<Integer> sub = new ArrayList();
        Arrays.sort(candidates);
        combination(li,sub,candidates,target,0);
        
        return li;
    }
    
    
    public void combination(List<List<Integer>> li, List<Integer> sub, int[] nums, int target,int start)
    {
        if(target == 0)
            li.add(new ArrayList(sub));
        
        if(target>0)
        {
            for(int i=start;i<nums.length;i++)
            {
                sub.add(nums[i]);
                combination(li,sub,nums,target- nums[i],i);
                sub.remove(sub.size()-1);
            }
        }
                
    }
}
