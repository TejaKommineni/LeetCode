package Companies;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BlackRock {
    
    public static final String SEPARATOR = "@";
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String printHoldings(String portfolioString) {
    
    	
        List<PortfolioHolding> holdings = new ArrayList<PortfolioHolding>();
        int lastIndex = 0;
        for(int i=0; i<portfolioString.length(); i++)
        {
            String temp = String.valueOf(portfolioString.charAt(i));
            if(SEPARATOR.equals(temp))
            {
              holdings.add(getHolding(portfolioString,lastIndex,i));
              lastIndex = i+1;
            }
        }
        holdings.add(getHolding(portfolioString,lastIndex,portfolioString.length()));
        Collections.sort(holdings, PortfolioHolding.PortfolioHoldingComparator);
        String output = "";
        for(PortfolioHolding holding: holdings)
        {
            output = output + "[" + holding.getTicker() +", "+ holding.getName() +", "+holding.getQuantity()+"], ";
        }
        output = output.substring(0,output.length()-2);

        return output;
    }
    
    static PortfolioHolding getHolding(String portfolioString, int start , int end)
    {
        String temp = portfolioString.substring(start,end);
        String split[] = temp.split(",");
        PortfolioHolding holding = new PortfolioHolding(split[0],split[1],split[2]);
        return holding;
    }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }
        res = printHoldings(_input);
        System.out.println(res);
    }
}
