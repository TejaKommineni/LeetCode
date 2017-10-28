package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	/*
	 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
	 * 
	 */
	

    public List<String> summaryRanges(int[] nums) {
        
        List<String> li = new ArrayList<String>();
        if(nums.length ==0)
        return li;
        
        int start = nums[0];
        int i=1;
        for(;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1]!=1)
            {
                if(start == nums[i-1])
                {
                    li.add(String.valueOf(start));
                    start = nums[i];
                }
                else
                {
                li.add(start+"->"+nums[i-1]);
                start = nums[i];
                }
            }
        }
        
        if(start == nums[i-1])
        li.add(String.valueOf(start));
        else
        li.add(start+"->"+nums[i-1]);   
        
        
        return li;
    }
}
