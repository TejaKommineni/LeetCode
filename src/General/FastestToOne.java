
public class FastestToOne {

	static int dp[];
	
	public int toOne(int a)
	{
		if(a == 1)
		  return dp[a]=0;
		
		if(dp[a]!=-1)
		  return dp[a];
		
		
		int temp= 1+toOne(a-1);
		
		if(a%2==0)
			temp= Math.min(temp,1+toOne(a/2));
		
		if(a%3==0)
			temp= Math.min(temp,1+toOne(a/3));

		dp[a]=temp;
		
		return temp;
		
	}
	
	public static void main(String[] args) {
		
		FastestToOne fo= new FastestToOne();
		dp = new int[10+1];
		for(int i=0;i<dp.length;i++)
		{
			dp[i]=-1;
		}
		
	System.out.print(fo.toOne(10));
		
	}
	
}
