
package LeetCode.Arrays;

/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray {


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k>=n)
        {
            k = k % n; 
        }
        if(k == 0)
            return ;
        reverse(nums, 0, n-k-1);
        reverse(nums,n-k, n-1);     
        reverse(nums,0,n-1);
        
    }
    public void reverse(int[] nums,int i, int j)
    {
        while(i<j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
	
}
