package LeetCode.General;
import java.util.HashMap;
import java.util.Map;


public class ContainsDuplicates {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
    
    public static void main(String[] args) {
    	ContainsDuplicates cd = new ContainsDuplicates();
    	int nums[] = {2,1,6,9,3,5,5};
    	System.out.println(cd.containsNearbyAlmostDuplicate(nums, 1, 1));
	}
    
}