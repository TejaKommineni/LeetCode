package DataMining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NGrams {	
	
	public HashSet twoGramCharacters(String fileName) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		HashSet<String> hs = new HashSet<String>();
		int token = bf.read(); 
		while(token!=-1)
		{
		    String temp = ""+(char)token;		    
			token = bf.read();
			temp = token!=-1?temp+(char)token:temp;
			if(!hs.contains(temp))
				hs.add(temp);
			token = token!=-1?bf.read():-1;
		}
			
		return hs;
	}
	
	public HashSet threeGramCharacters(String fileName) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		HashSet<String> hs = new HashSet<String>();
		int token = bf.read();
		while(token!=-1)
		{
		    String temp = ""+(char)token;		    
			token = bf.read();
			temp = token!=-1?temp+(char)token:temp;
			token = bf.read();
			temp = token!=-1?temp+(char)token:temp;
			if(!hs.contains(temp))
				hs.add(temp);
			token = token!=-1?bf.read():-1;
		}
			
		return hs;
	}
		
	public HashSet twoGramWords(String fileName) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		HashSet<String> hs = new HashSet<String>();
		String token = bf.readLine(); 
		String temp="";
		int count=0;
		while(token!=null)
		{  			
		    String words[] =token.split(" ");
		    for(int i=0;i<words.length;i++)
		    {		 
		    	
		    	if(words[i].trim().equals(""))
		    		continue;
		    	else 
		    	{
		    	  temp = temp+ words[i].trim()+" ";
		    	  count++; 
		    	}
		    	if(count==2)
		    	{
		    		count=0;
		    		if(!hs.contains(temp.trim()))
		    			hs.add(temp.trim());
		    		temp = "";
		    	}
		    	  	
		    		
		    }
			token = bf.readLine();
		}
		if(temp!="")
			if(!hs.contains(temp.trim()))
    			hs.add(temp.trim());	
			
			
		return hs;
	}
	
	public double jaccardSimilarity(String f1, String f2) throws IOException
	{
		HashSet hs = twoGramCharacters(f1);
		HashSet hs1 = twoGramCharacters(f2);
		int size = hs.size();
		int size1 = hs1.size();
		hs.addAll(hs1);	
		double answer = size+size1-hs.size();
		answer = answer/hs.size();
		return answer;		
	}
	
	public boolean validNotepad(String fileName) throws IOException
	{
		BufferedReader bf = new BufferedReader(new FileReader(fileName));
		String firstLine = bf.readLine();
		if(firstLine == null)
			return false;
		if(firstLine.charAt(firstLine.length()-1)!='~')
			return false;
		String temp[] = firstLine.split("\\*");		
		String lastString= temp[temp.length-4];		
		String secondLine = bf.readLine();
		if(secondLine == null)
			return false;
		temp = secondLine.split("\\*");		
		String penultimateString = temp[temp.length-3];
		
		List<String> previousLines = new ArrayList();		
		String presentLine = bf.readLine();
		while(presentLine!=null)
		{
			if(presentLine.charAt(presentLine.length()-1)!='~')
			return false;	
			previousLines.add(presentLine);
			if(previousLines.size()>2)
			   previousLines.remove(0);
			presentLine = bf.readLine();
		}
				
		if(!previousLines.get(0).contains(penultimateString))
		  return false;
		if(!previousLines.get(1).contains(lastString))
			  return false;
		
		
	   return true;
	}
	public static void main(String[] args) throws IOException {
		
		NGrams n = new NGrams();
		n.validNotepad("notepad.txt");
		System.out.println(n.jaccardSimilarity("D2.txt","D4.txt"));
		System.out.println(n.twoGramWords("D1.txt").size());
		System.out.println(n.twoGramCharacters("D4.txt"));
		System.out.println(n.threeGramCharacters("D4.txt"));
	}

}
