package Codejam;

import java.io.*;
import java.util.*;

public class D {
  private static InputReader in;
  private static PrintWriter out;
  public static boolean SUBMIT = false;
  public static final String NAME = "A-small-practice";

	private static void main2() throws IOException {
		
		long N = in.nextInt();
        long X = in.nextInt();
        String s = in.next();

        String curr = "1";
        for (int i = 0; i < N; i++)
        {
            String t = s.charAt(i) + "";
            curr = mult(curr, t);
        }
//        System.out.println("curr: " + curr);
        String all = "1";
        for (int j = 0; j < X % 4; j++)
            all = mult(all, curr);
//        System.out.println("all: " + all);
        int bestLeft = -1, bestRight = -1;
        curr = "1";
        for (int i = 0; i < N * X && i < 4 * N; i++)
        {
            String t = s.charAt((int) (i % N)) + "";
            curr = mult(curr, t);
            if (curr.equals("i"))
            {
                bestLeft = i + 1;
                break;
            }
        }
        curr = "1";
        for (int i = 0; i < N * X && i < 4 * N; i++)
        {
            String t = s.charAt((int) (N - 1 - i % N)) + "";
            curr = mult(t, curr);
            if (curr.equals("k"))
            {
                bestRight = i + 1;
                break;
            }
        }
//        System.out.println("bestLeft: " + bestLeft);
//        System.out.println("bestRight: " + bestRight);
        boolean good = all.equals("-1") && bestLeft != -1 && bestRight != -1 && bestLeft + bestRight < N * X;
        out.println();
		
	}
  
	private static void main1() throws IOException
	{
		
	}
	static String mult(String a, String b)
    {
        boolean neg = false;
        if (a.charAt(0) == '-')
        {
            a = a.substring(1);
            neg ^= true;
        }
        if (b.charAt(0) == '-')
        {
            b = b.substring(1);
            neg ^= true;
        }
        String ans;
        if (a.equals("1"))
            ans = b;
        else if (b.equals("1"))
            ans = a;
        else if (a.equals(b))
            ans = "-1";
        else if (a.equals("i"))
            ans = b.equals("j") ? "k" : "-j";
        else if (a.equals("j"))
            ans = b.equals("i") ? "-k" : "i";
        else
            ans = b.equals("i") ? "j" : "-i";
        if (ans.charAt(0) == '-')
        {
            ans = ans.substring(1);
            neg ^= true;
        }
        if (neg)
            ans = "-" + ans;
        return ans;
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
