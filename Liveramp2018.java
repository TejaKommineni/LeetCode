package LeetCode;

public class Liveramp2018 {

	

    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int temp[] = new int[A.length];
        int k = 0;
        for(int i=0;i<A.length;i++)
        {
            if(temp[A[i]] == 0)
                {
                    temp[A[i]]++;
                    k++;
                }
        }
        
        int minimumDays = Integer.MAX_VALUE;
        int begin =0;
        int end = 0;        
        while(end < temp.length)
        {
            
            if(temp[A[end++]]-- >0) 
                k--;
            
            while(k == 0)
            {
                minimumDays = Math.min(minimumDays, end-begin);
                if(temp[A[begin++]]++ >=0)
                    k++;
            }
        
        }
        return minimumDays;
    }
	
	
	public static void main(String[] args) {
		
		Liveramp2018 l = new Liveramp2018();
		System.out.println(l.solution(new int[] {7, 5, 2, 7, 2, 7, 4, 7}));
	}
}
