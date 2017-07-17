package Companies;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BlackRock_1 {
    public static String SEPARATOR = "@";
    public static final String COLON = ":";
    public static final String BUY = "BUY";
    public static final String SELL = "SELL";
    public static final String FORMAT = "0.00";
    
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

    static String generateTransactions(String input) {
        
        String split[] = input.split(COLON);
        ArrayList<PortfolioHolding> portfolios = getHoldings(split[0]);
        ArrayList<PortfolioHolding> benchmarks = getHoldings(split[1]);
        Collections.sort(portfolios, PortfolioHolding.PortfolioHoldingComparator);
        Collections.sort(benchmarks, PortfolioHolding.PortfolioHoldingComparator);
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        for(int i=0;i<portfolios.size();i++)
        {
            PortfolioHolding portfolio =  portfolios.get(i);
            PortfolioHolding benchmark =  benchmarks.get(i);
            
            double portfolioQuantity = Double.parseDouble(portfolio.getQuantity());
            double benchmarkQuantity = Double.parseDouble(benchmark.getQuantity());
            DecimalFormat decim = new DecimalFormat(FORMAT);
            Transaction transaction;
            if(portfolioQuantity<=benchmarkQuantity)
            {
             transaction  = new Transaction(BUY,portfolio.getTicker(),decim.format(benchmarkQuantity-portfolioQuantity));
            }
            else
            {
             transaction= new Transaction(SELL,portfolio.getTicker(),decim.format(portfolioQuantity-benchmarkQuantity));
            }
            transactions.add(transaction);
        }
        
        String output = "";
        for(Transaction transaction: transactions)
        {
            output = output + "[" + transaction.getType() +", "+ transaction.getTicker() +", "+transaction.getQuantity()+"], ";
        }
        output = output.substring(0,output.length()-2);

        return output;   
    }
    
    static ArrayList<PortfolioHolding> getHoldings(String portfolioString)
    {
        ArrayList<PortfolioHolding> holdings = new ArrayList<PortfolioHolding>();
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
        return holdings;
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
        res = generateTransactions(_input);
        System.out.println(res);
    }
}



