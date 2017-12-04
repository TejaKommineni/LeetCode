package LeetCode.Contests;

import java.util.Stack;

public class Contest61 {
/*
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> s = new Stack<Integer>();
        int [] answer = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++)
        {
            while(!s.isEmpty() && temperatures[s.peek()]<temperatures[i])
            {
                answer[s.peek()] = i-s.peek();
                s.pop();
            }    
            s.push(i);
        }
        while(!s.isEmpty())
        {
            answer[s.pop()] = 0;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		
	}
}
