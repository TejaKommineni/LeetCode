package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	/*
	 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
	 */
	

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> li = new ArrayList();
        List<Integer> sub = new ArrayList();
        Arrays.sort(candidates);
        combination(li,sub,candidates,target,0);
        return li;
    }
    public void combination(List<List<Integer>> li,List<Integer> sub, int[] candidates, int target, int start )
    {   
        if(target <0)
            return;
        if(target == 0)
        li.add(new ArrayList(sub));
        
        for(int i =start;i<candidates.length;i++)
        {
            if(i>start && candidates[i] == candidates[i-1])
                continue;
            sub.add(candidates[i]);
            combination(li,sub,candidates,target-candidates[i],i+1);
            sub.remove(sub.size()-1);
        }
    }
}
