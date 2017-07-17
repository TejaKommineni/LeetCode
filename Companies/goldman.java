package Companies;
import java.util.HashMap;


public class goldman {

	
	
	static int countPairs(int k, int[] a) {

        int count =0;
        for(int i=0;i<a.length;i++)
          {
            for(int j=0;j<a.length;j++)
              {
                if(i==j)
                    continue;
                else
                  {
                   if(a[i]+a[j] == k)
                       count++;
                }
            }
        }
       
        return count/2;

    }
	
	public void test(int k,int a[])
	{
		
		HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();		
		for(int i=0;i<a.length;i++)
		{
			if(hs.containsKey(a[i]))
			{
				hs.put(a[i], hs.get(a[i])+1);
			}
			else
			{
				hs.put(a[i], 1);
			}
			
		}
		int count=0;
		for(int i=0;i<a.length;i++)
		{
			count= count+ hs.get(k -a[i]);
			
			if(k -a[i] == a[i])
			{
				count--;
			}
			
		}
		
		System.out.print(count);
		
		
		
	}

	public static void main(String[] args) {
		
		goldman g = new goldman();
		int a[] = {1,1,1,3};
		g.test(2,a);
	}
}
