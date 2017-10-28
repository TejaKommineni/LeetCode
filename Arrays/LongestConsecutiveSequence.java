package LeetCode.Arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {

/*
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */

    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet();
        for(int i=0;i<nums.length;i++)
        {
            if(!hs.contains(nums[i]))
                hs.add(nums[i]);
        }
        int count =0;
        for(int i=0;i<nums.length;i++)
        {
            int po=0,ne=0;
            if(hs.contains(nums[i])){
            int emp =nums[i]+1;
            int nemp=nums[i]-1;
            while(hs.contains(emp++))
            {
                po++;
                hs.remove(emp-1);
            }            
            while(hs.contains(nemp--))
            {
                ne++;
                hs.remove(nemp+1);
            }}
            hs.remove(nums[i]);
            count = Math.max(count,po+ne+1 );
        }
        return count;
    }
}
