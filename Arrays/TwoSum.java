package LeetCode.Arrays;

public class TwoSum {

	  public int[] twoSum(int[] numbers, int target) {
	        
	        int i=0;
	        int j = numbers.length-1;
	        int[] answer = new int[2];
	        while(i<j)
	        {
	            if(numbers[i] + numbers[j] == target)
	            {
	                answer[0] = i+1;
	                answer[1] = j+1;
	                break;
	            }
	            if( numbers[i]+numbers[j]<target)
	                i++;
	            else
	                j--;
	        }
	        return answer;
	    }
}
