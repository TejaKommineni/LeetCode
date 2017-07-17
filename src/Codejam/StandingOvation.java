package Codejam;

import java.io.*;
import java.util.*;

public class StandingOvation {
  private static InputReader in;
  private static PrintWriter out;
  public static boolean SUBMIT = true;
  public static final String NAME = "A-large-practice";

  private static void main2() throws IOException {
    int max  = in.nextInt();
    String s = in.next();
    int extra=0;
    int tillNow =s.charAt(0)-'0';
    for(int i=1;i<=max;i++)
    {
    	if(s.charAt(i)-'0'>0)
    	{
    		if(tillNow<i)
    		{
    			extra =+ (i-tillNow); 
    			tillNow = tillNow + s.charAt(i)-'0';
    		}
    		else
    		{
    			tillNow = tillNow + (s.charAt(i)-'0');
    		}
    	}
    }
   	 out.println(extra);   
   
  }
  private static void main1() throws IOException {

      int N = in.nextInt();
      String s = in.next();

      int total = 0, numFriends = 0;
      for (int i = 0; i <= N; i++)
      {
          int d = s.charAt(i) - '0';
          if (d > 0 && total < i)
          {
              numFriends += i - total;
              total = i;
          }
          total += d;
      }
	   
	   	 out.println(numFriends);   
	   
	  }
  

  
  
  public static void main(String[] args) throws IOException {
    if (SUBMIT) {
      in = new InputReader(new FileInputStream(new File(NAME + ".in")));
      out = new PrintWriter(new BufferedWriter(new FileWriter(NAME + "1.out")));
    } else {
      in = new InputReader(System.in);
      out = new PrintWriter(System.out, true);
    }

    int numCases = in.nextInt();
    for (int test = 1; test <= numCases; test++) {
      out.print("Case #" + test + ": ");
      main2();
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
    public double nextDouble() {
        return Double.parseDouble(next());
      }
  }
}
