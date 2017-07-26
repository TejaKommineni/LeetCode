package LeetCode.Arrays;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow =0, fast = nums[0];
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[nums[slow]];
        }
        fast =0;
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        
    }
    
    public static void main(String[] args) {
		FindDuplicate f = new FindDuplicate();
		f.findDuplicate(new int[] {1,3,4,2,2});
	}
}