package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDup {

/*
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
	

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> li = new ArrayList();
        List<Integer> sub = new ArrayList();
        Arrays.sort(nums);
        subsets(li,sub,0,nums);
        
        return li;
        
    }
    
    public void subsets(List<List<Integer>> li, List<Integer> sub, int start, int[] nums)
    {
        
        li.add(new ArrayList(sub));
        for(int i=start;i<nums.length;i++)
        {
            if(i>start && nums[i] == nums[i-1])
                continue;
            sub.add(nums[i]);
            subsets(li,sub,i+1,nums);
            sub.remove(sub.size()-1);
                
        }
    }
}
