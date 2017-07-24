package LeetCode.General;
public class GridUniquePaths {

	
	
	
	public static void main(String[] args) {
		
		System.out.println("There are "+ twoSteps(0,0,5,8) + " unique paths to the destination.");
	}

	private static int twoSteps(int i, int j, int m, int n) {
		int count=0;
		
		if(i==m-1 && j==n-1)
		{
			return 1;
		}
		
		else if(i==m-1)
		{
			count = count + twoSteps(i,j+1,m,n);
		}	
		
		else if(j==n-1)
		{
			count = count + twoSteps(i+1,j,m,n);
		}	
		
		else
		{
			count = count + twoSteps(i,j+1,m,n);
			count = count + twoSteps(i+1,j,m,n);			
		}	
		
		return count;
	}
}
