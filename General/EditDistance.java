package LeetCode.General;
import java.util.ArrayList;


public class EditDistance {
	
	
	
	
	public static void main(String[] args) {
		
		EditDistance ed= new EditDistance();
		
		System.out.println("Least number of steps to convert source to dst are "+ ed.editDistance("aaaaa","aabaa",0));
	}

	private int editDistance(String src, String dst, int i) {
		
		if(src.equalsIgnoreCase(dst))
			return 0;
		
		if(i>=dst.length())
			return 9999;
		
		int replace=999;
		int insert =999;
		int delete =999;
		
		if(i>=src.length())
		{
			ArrayList<Character> ins= new ArrayList<Character>();
			for(int k=0;k<src.length();k++)
			{  
				 ins.add(src.charAt(k));
				
			}			
				
			ins.add(dst.charAt(i));
			char insc[] = new char[ins.size()];
			for(int k=0;k<ins.size();k++)
				insc[k]=ins.get(k);
			
			insert= 1+editDistance(new String(insc),dst,i+1);
		}
		else
		{
		
		String src_sub=src.substring(i, i+1);
		String dst_sub=dst.substring(i, i+1);

		
		
		
		if(src_sub.equalsIgnoreCase(dst_sub) && i==dst.length()-1)
		   delete=src.length()-dst.length();		
		else if(src_sub.equalsIgnoreCase(dst_sub))
		{
			replace=editDistance(src,dst,i+1);
		}
	
		else
		{
			ArrayList<Character> rep= new ArrayList<Character>();
			ArrayList<Character> ins= new ArrayList<Character>();
			ArrayList<Character> del= new ArrayList<Character>();
			
			
			
			for(int k=0;k<src.length();k++)
			{
				if(k==i)
				 {
					rep.add(dst_sub.toCharArray()[0]);	
					ins.add(dst_sub.toCharArray()[0]);
					ins.add(src.charAt(k));
				 }
				else
				{	
				 rep.add(src.charAt(k));	
				 ins.add(src.charAt(k));
				 del.add(src.charAt(k));
				}			
				
			}
			
			char repc[] = new char[rep.size()];
			char insc[] = new char[ins.size()];
			char delc[] = new char[del.size()];
			
			for(int k=0;k<rep.size();k++)
			repc[k]=rep.get(k); 
			
			for(int k=0;k<ins.size();k++)
				insc[k]=ins.get(k);
			
			for(int k=0;k<del.size();k++)
				delc[k]=del.get(k);
						
			 replace = 1+editDistance(new String(repc),dst,i+1);
			insert= 1+editDistance(new String(insc),dst,i+1);
			delete = 1+editDistance(new String(delc),dst,i+1);
		}
		}
		
		int minimum=Math.min(insert, delete);
		return Math.min(replace,minimum);
	}
	
	
}
