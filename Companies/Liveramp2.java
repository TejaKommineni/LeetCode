package Companies;
import java.util.Arrays;


public class Liveramp2 {
	
	public int solution(int[] A) {
		
		int sorted[] = new int[A.length];
		
		for(int i=0;i<A.length;i++)
		{
			sorted[i] = A[i];
		}
		
		Arrays.sort(sorted);
		
		int i=0, j=0, lastIndex=0;
		while(i<A.length)
		{
			if(A[i]== sorted[i])
			{
				i++;	
				
			}
			else
			{
				
				if(j>0)
				{
					j = j-1 + (i - lastIndex);
				}
				lastIndex = i;
			    j++;
				i++;
			}
		}
		
		return j;
        
    }

	public static void main(String[] args) {
		
		Liveramp2 l = new Liveramp2();
		int A[] = {1,2,6,5,5,8,9,12,10,11,13};
		l.solution(A);
		
	} 
	
}
