package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int i=0;i<nums.length;i++)
        {
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = temp;
        }   
        List<Integer> li = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
         if(nums[i]-1 !=i)
         li.add(i+1);   
        }
    return li;
    }
    
  
 
    public static void main(String[] args) {
		DisappearedNumbers di = new DisappearedNumbers();
		di.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
		//di.generate(5);
		//di.containsNearbyDuplicate(new int[] {3,1,2,4,1,2}, 1);
		
		
	}
}

