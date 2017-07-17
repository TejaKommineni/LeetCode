import java.util.Arrays;

public class EditDistanceSolution {
    
    private int dp[][];
    private String A, B;
    
	public int minDistance(String A, String B) {
	    
	    if (A == null && B == null)
	        return 0;
	    
	    int nA, nB;
	    nA = A.length();
	    nB = B.length();
	    
	    if (nA == 0)
	        return nB;
	        
	    if (nB == 0)
	        return nA;
	    
	    dp = new int[nA][nB];
	    this.A = A;
	    this.B = B;
	    
	    for (int i = 0; i < nA; i++)
	        Arrays.fill(dp[i], -1);
	    
	    int res = rec(nA - 1, nB - 1);
	    
	    return res;
	}
	
	public int rec(int iA, int iB) {
	    
	    if (iA < 0 && iB < 0)
	        return 0;
	    
	    if (iA < 0)
	        return iB + 1;
	        
	    if (iB < 0)
	        return iA + 1;
	        
	    if (dp[iA][iB] != -1)
	        return dp[iA][iB];
	    
	    int res = Integer.MAX_VALUE;
	    
	    if (A.charAt(iA) == B.charAt(iB))
	        res = rec(iA - 1, iB - 1);
	    
	    int temp = 1 + rec(iA - 1, iB - 1);
	    temp = Math.min(temp, 1 + rec(iA - 1, iB));
	    temp = Math.min(temp, 1 + rec(iA, iB - 1));
	    
	    res = Math.min(res, temp);
	    
	    return dp[iA][iB] = res;
	}	
}


