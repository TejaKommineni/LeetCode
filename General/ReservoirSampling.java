package LeetCode.General;
import java.util.Random;


public class ReservoirSampling {
	
	 int[] nums;
	    Random rnd;

	    public ReservoirSampling(int[] nums) {
	        this.nums = nums;
	        this.rnd = new Random();
	    }
	    
	    public int pick(int target) {
	        int result = -1;
	        int count = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] != target)
	                continue;
	            if (rnd.nextInt(++count) == 0)
	                result = i;
	        }
	        
	        return result;
	    }
	    
	    public static void main(String[] args) {			
	    	int nums[] ={1,2,3,3,3}; 
	    	ReservoirSampling r = new ReservoirSampling(nums);
	    	System.out.println(r.rnd.nextInt(1));
	    	System.out.println(r.pick(3));
	    	System.out.println(r.pick(3));
	    	System.out.println(r.pick(3));
		} 
	    

}
