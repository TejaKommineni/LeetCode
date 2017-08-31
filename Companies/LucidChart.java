package LeetCode.Companies;

public class LucidChart {


	/**
	 * Take a rectangular grid of numbers and find the length
	 * of the longest sub-sequence.
	 * @return the length as an integer.
	 */
    public static final int[][] dirs  = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
	public static int longestSequence(int[][] grid) {
		// TODO: implement this function
        if(grid.length == 0)
            return 0;
        
        int  m = grid.length, n = grid[0].length;
        int max = 1;
        boolean visited [][] = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
            	visited[i][j] = true;
                int len = dfs(grid,i,j,m,n,visited);
                max = Math.max(max,len);
                visited[i][j] = false;
                if(max == m*n)
                	break;
            }
            
            if(max == m*n)
            	break;
        }
        
        
		return max;
	}

    public static int dfs(int [][] grid, int i, int j, int m, int n, boolean[][] visited)
    {
        int max =1;
        for(int [] dir : dirs)
        {
            int x = i+dir[0], y = j+dir[1];
            if(x<0 || x>=m || y<0 || y>=n || visited[x][y] || Math.abs(grid[i][j] - grid[x][y])<=3)
                continue;
            visited[x][y] = true;
            int len = 1+dfs(grid, x, y, m, n, visited);
            max = Math.max(max,len);
            visited[x][y] = false;
            
            if(max == m*n)
            	break;
        }
        
        return max;
    }
    
	
	public static void main(String[] args) {
		
		LucidChart lc = new LucidChart();
		int [][] grid = new int[][] {{8,2,9, 13},{8,2,9,13},{8,2,9,13},{8,2,9,13}};
		// int [][] grid = new int[][] {{1,5,7,11,15},{1,2,9, 13, 13},{2,2,0,1,13},{1,2,3,13,13},{0,0,0,0,0},{2,2,9,1,13},{2,2,9,13,0},{1,1,1,1,1}};
		// int [][] grid = new int[][] {{1,5,9,13,29},{61,57,53,17,33},{41,45,49,21,34},{37,33,29,25}};
		lc.longestSequence(grid);
	}
}
