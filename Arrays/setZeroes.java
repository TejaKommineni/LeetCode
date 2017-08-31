package LeetCode.Arrays;

public class setZeroes {
	
	public void setZeroes(int[][] matrix) {
        if(matrix.length >0)
        {
            boolean firstRow = false;
            boolean firstColumn = false;


            
        for(int i=0;i<matrix.length;i++)
        {
          if(matrix[i][0] == 0)
        	  firstColumn = true;        	  
        }
        for(int i=0;i<matrix[0].length;i++)
        {
          if(matrix[0][i] == 0)
        	  firstRow = true;        	  
        }
        
        for(int i=1;i<matrix.length;i++)
        {
        	for(int j=1;j<matrix.length;j++)
        	{
        		if(matrix[i][j]==0)
        	   {
        			matrix[0][j] = 1;
        		    matrix[i][0] = 1;
        	   }
        	}
        }
        
        for(int i=1;i<matrix.length;i++)
        {
        	for(int j=1;j<matrix.length;j++)
        	{
        		if(matrix[i][0]==1 || matrix[0][j]==1)
        	   {
        			matrix[i][j] = 0; 
        	   }
        	}
        }
        if(firstColumn) {
        for(int i=0;i<matrix.length;i++)
        {
          matrix[i][0] = 0;
        	          	  
        }}
        if(firstRow) {
            for(int i=0;i<matrix[0].length;i++)
            {
              matrix[0][i] = 0;
            	          	  
            }}
        
        
        }
    }

}
