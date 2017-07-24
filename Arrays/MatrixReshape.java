package LeetCode.Arrays;

public class MatrixReshape {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        
        int rows = nums.length;
        if(rows == 0)
            return nums;
        int cols = nums[0].length;
        
        int ans[][] = new int[r][c];
        if(r*c != rows*cols)
            return nums;
        else
        {
            int row =0, col=0; 
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    ans[i][j] = nums[row][col++];
                    if(col == cols)
                    {
                       row++;
                       col=0;
                    }
                    
                }
            }
            
        }
        return ans;
        
        
    }
}