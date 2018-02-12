package LeetCode;

public class Veritas2018 {
	
	
	

	
	public static void main(String[] args) {
		
		
		int x = 2437;
		int y = 875;
		
		while(x !=y)
		{
			if(x >y)
				x = x-y;
			if(x <y )
				y = y-x;
		}
		
		System.out.println(x);
		
		
		int s = 0;
		
		while(s++ <10)
		{
			if(s<4 && s<9)
				continue;
			else
				System.out.print(s);
		}
		
	}
}
