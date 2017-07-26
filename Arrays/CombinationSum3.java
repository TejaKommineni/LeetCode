package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> li = new ArrayList();
               List<Integer> sub = new ArrayList();
        calculate(li,sub,1,k,n);
        
        return li;
    }
    
    public void calculate(List li, List sub,int start, int size, int target)
    {
        if(target == 0 && size == 0)
        	li.add(new ArrayList(sub));
        for(int i=start;i<=9;i++)
        {
        	sub.add(i);
        	calculate(li,sub,i+1,size-1,target-i);
        	sub.remove(sub.size()-1);
        }
        
    }

    public static void main(String[] args) {
		CombinationSum3 cs = new CombinationSum3();
		cs.combinationSum3(3, 9);
	}
}
