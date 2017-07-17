package Contests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest27 {
	
	public String reverseWords(String s) {
        int start =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
        if(s.charAt(i)==' '){
            sb.append(reverse(s, start, i-1)); 
            sb.append(" ");
            start=i+1;
        }
        }
        sb.append(reverse(s, start, s.length()-1)); 
		return sb.toString();
        
    }
    
    public String reverse(String s, int i, int j){
        StringBuilder str = new StringBuilder(s.substring(i,j+1));
        return str.reverse().toString();
    }
	//Line 42: java.lang.NumberFormatException: For input string: ""
    public int nextGreaterElement(int n) {
    	String s = String.valueOf(n);
    	boolean flag = true;
    	int i=s.length()-2;
    	for(;i>=0;i--)
    	{
    		if(s.charAt(i)<s.charAt(i+1))
    		{
    			flag = false;
    			break;
    		}
    	}
    	if(flag)
    		return -1;
    	
    	int smallest = 10;
    	int k =0;
    	for(int j=i+1;j<s.length();j++)
    	{
    		if(s.charAt(j)>s.charAt(i))
    		{
    			if(smallest>s.charAt(i)-'0')
    			{	smallest = s.charAt(j)-'0';
    				k = j;
    			}
    		}
    	}
    	StringBuilder s1 = new StringBuilder(s);
    	
    	int temp = s.charAt(i) -'0';
    	s1.deleteCharAt(i);
    	s1.insert(i, (char)('0'+smallest));
    	s1.deleteCharAt(k);    	
    	s1.insert(k, (char)('0'+temp));
    	char[] charArray = s1.substring(i+1).toCharArray();
    	Arrays.sort(charArray);
    	String sortedString = new String(charArray);    	
    	s1 = new StringBuilder(s1.substring(0, i+1));
    	s1.append(sortedString);
    	int output;
    	try{
    		output = Integer.parseInt(s1.toString());
    		}catch(NumberFormatException ex){ // handle your exception
    		   return -1;
    		}
		return  output;   
    }
	
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k; 
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
    
	public static void main(String[] args) {
		Contest27 c = new Contest27();
		System.out.println(c.reverseWords("Let's take LeetCode contest"));
		System.out.println(c.nextGreaterElement(546789));
		int nums[]= {23, 2, 6,4, 7};
		System.out.println(c.checkSubarraySum(nums,6));
		
	}

}
