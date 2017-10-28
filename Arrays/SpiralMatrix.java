package LeetCode.Arrays;

public class SpiralMatrix {

	/*
	 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
	 * 
	 */

    public int[][] generateMatrix(int n) {
        int ans [][] = new int[n][n];
        int count =1;
        int left =0;
        int right = n-1;
        int bottom = n-1;
        int top =0;
        int number =1;
        while(count<=n*n)
        {
            for(int i=left;i<=right;i++)
            {
              ans[top][i] = number++;  
            }
            top++;
            for(int i=top;i<=bottom;i++)
            {
                ans[i][right]= number++;
            }
            right--;
            for(int i=right;i>=left;i--)
            {
                ans[bottom][i] =number++; 
            }
            bottom --;
            for(int i=bottom;i>=top;i--)
            {
                ans[i][left] = number++;
            }
            left++;
            
            count++;
        }
        return ans;
    }
}
