package LeetCode.Codejam;

import java.io.*;
import java.util.*;

public class Cookies {
  private static InputReader in;
  private static PrintWriter out;
  public static boolean SUBMIT = true;
  public static final String NAME = "B-large-practice";

  private static void main2() throws IOException {
    double C  = in.nextDouble();
    double F = in.nextDouble();
    double X = in.nextDouble();

	double time = 0; double curr =2.0;
	
	while(true)
	{
	if((X/curr) + time < (X/(curr+F)) +(time)+(C/curr))
	{
		break;
	}
	else
	{	
		time = time+C/curr;
		curr = curr+F;
	}
	
		
	}
	 out.println((time+(X/curr)));   
    
  }
  
  private static void main1() throws IOException
  {int MAXFARMS = 1000000;
	  double c = in.nextDouble();
		double f = in.nextDouble();
		double x = in.nextDouble();
		int curFarms = 0;
		double ans = 1e9;
		double time = 0;
		boolean done = false;
		while(!done || curFarms < MAXFARMS) {
			double tans = (x / (2 + f*curFarms)) + time;
			if(tans <= ans) ans = tans;
			else done = true;
			time += c / (2 + f*curFarms);
			curFarms++;
		}
		out.println(ans+1e-9);
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
    public double nextDouble() {
        return Double.parseDouble(next());
      }
  }
}
