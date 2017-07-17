package Codejam;

import java.io.*;
import java.util.*;

public class A {
  private static InputReader in;
  private static PrintWriter out;
  public static boolean SUBMIT = false;
  public static final String NAME = "B-large";
  public static HashMap<String,Integer> memo = new HashMap();
  	private static void main2() throws IOException {
		
		long n = in.nextLong();
		if(n<=9)
		{
			out.println(n);
		}
		else
		{
			String temp = String.valueOf(n);
			boolean flag = true;
			for(int i =0;i<temp.length();i++)
			{
			if(temp.charAt(i) >= '2')
				{flag = false;
			    break;
				}
			}	
		    String output="";
			if(flag)
			{				
					
				for(int i=0;i<temp.length()-1;i++)
				{
					output = output+"9";
				}
				out.println(output);
			}
			else
			{		int i=1;		
				for(;i<temp.length();i++)
				{
					if(temp.charAt(i)<temp.charAt(i-1))
					{
						break;
					}
					else
					output = output+temp.charAt(i-1);	
				}
				if(i==temp.length())
					out.println(output+temp.charAt(temp.length()-1));
				else
				{
					output = output+ (char)(temp.charAt(i-1)-1);
					String temp2 =output;
					int k =i-2;
					for(;k>=0;k--)
					{
						if(temp.charAt(i-1) == temp.charAt(k))
						{
							output = output.substring(0,k)+(char)(temp.charAt(i-1)-1)+convertTo(output.substring(k+1));
						}
					}	
					
				for(int j=i;j<temp.length();j++)
				{
					output = output+"9";
				}
				if(output.charAt(0)=='0')
				{
					output = output.substring(1);
				}
				out.println(output);
				}
			}	
			
		}       
		
	}
  
  private static String convertTo(String substring) {
		
	  String temp = "";
	    for(int i=0;i<substring.length();i++)
	    {
	    	temp =temp+"9";
	    }
		return temp;
	}

  private static void main1() throws IOException
	{
		String pancake = in.next();
		int window = in.nextInt();
		minimumUsage(pancake,window,0);
		out.println(memo);
	}
private static int minimumUsage(String pancake, int window, int start) {
	
	if(start > pancake.length()-window)
		return 0;
		
	if(memo.containsKey(pancake))
		return memo.get(pancake);
	else
	{
		boolean flag = false;
		String output ="";
		int min = Integer.MAX_VALUE;
		for(int i=start; i<pancake.length()-window && i<start+window;i++)
		{
			if(pancake.charAt(i)=='-')
			flag = true;
			
			output = output + (pancake.charAt(i)=='+'?"-":"+");
		}		
		
		if(flag)
		{
			output = pancake.substring(0,start)+output+pancake.substring(start+window);
			min = 1+ minimumUsage(output,window,start);
		}
		else
		min =  	minimumUsage(pancake,window,start+1);		
		memo.put(pancake, min);
		return min;
	}
}

public static void main(String[] args) throws IOException {
    if (SUBMIT) {
      in = new InputReader(new FileInputStream(new File(NAME + ".in")));
      out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + ".out")));
    } else {
      in = new InputReader(System.in);
      out = new PrintWriter(System.out, true);
    }

    int numCases = in.nextInt();
    for (int test = 1; test <= numCases; test++) {
      out.print("Case #" + test + ": ");
      main1();
    }

    out.close();
    System.exit(0);
  }

static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
      }
    public double nextDouble() {
        return Double.parseDouble(next());
      }
  }
}
