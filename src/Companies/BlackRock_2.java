package Companies;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BlackRock_2 {
	public static final String SEPARATOR = "@";
	public static final String COLON = ":";
	public static final String FORMAT = "0.00";
	public static final String BUY = "BUY";
	public static final String SELL = "SELL";

	/*
	 * Complete the function below.
	 * 
	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */

	static String printHoldingsWithWeight(String inputString) {
		String split[] = inputString.split(COLON);
		ArrayList<PortfolioHolding> portfolios = getHoldings(split[0]);
		ArrayList<PortfolioHolding> benchmarks = getHoldings(split[1]);
		Collections.sort(portfolios,
				PortfolioHolding.PortfolioHoldingComparator);
		Collections.sort(benchmarks,
				PortfolioHolding.PortfolioHoldingComparator);
		double netPortfolioAssetValue = 0;
		double netBenchmarkAssetValue = 0;
		for (int i = 0; i < portfolios.size(); i++) {
			PortfolioHolding portfolio = portfolios.get(i);
			PortfolioHolding benchmark = benchmarks.get(i);
			double portfolioPrice = benchmark.getPrice();
			double portfolioValue = portfolioPrice * portfolio.getQuantity();
			double benchMarkValue = portfolioPrice * benchmark.getQuantity();
			portfolio.setPrice(portfolioPrice);
			portfolio.setValue(portfolioValue);
			benchmark.setValue(benchMarkValue);
			netPortfolioAssetValue = netPortfolioAssetValue + portfolioValue;
			netBenchmarkAssetValue = netBenchmarkAssetValue + benchMarkValue;
		}
		for (int i = 0; i < portfolios.size(); i++) {
			double perNetAssetValue = ((portfolios.get(i).getValue()) / netPortfolioAssetValue) * 100;
			portfolios.get(i).setNetAssetValue(perNetAssetValue);
			perNetAssetValue = ((benchmarks.get(i).getValue()) / netBenchmarkAssetValue) * 100;
			benchmarks.get(i).setNetAssetValue(perNetAssetValue);
		}

		ArrayList<Transaction> transactions = getTransactions(portfolios,
				benchmarks, netPortfolioAssetValue);
		String output = "";
		DecimalFormat decim = new DecimalFormat(FORMAT);

		// for(PortfolioHolding holding: portfolios)
		// {
		// output = output + "[" + holding.getTicker() +", "+ holding.getName()
		// +
		// ", "+Math.round(holding.getQuantity())+", "+decim.format(holding.getPrice())+", "+decim.format(holding.getValue())+", "+decim.format(holding.getNetAssetValue())
		// +"], ";
		// }

		for (Transaction transaction : transactions) {
			output = output + "[" + transaction.getType() + ", "
					+ transaction.getTicker() + ", "
					+ decim.format(transaction.getQuantity()) + "], ";
		}
		output = output.substring(0, output.length() - 2);

		System.out.println(output);
		return output;
	}

	static ArrayList<Transaction> getTransactions(
			ArrayList<PortfolioHolding> portfolios,
			ArrayList<PortfolioHolding> benchmarks,
			double netPortfolioAssetValue) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		for (int i = 0; i < portfolios.size(); i++) {
			Transaction transaction = null;
			double perNetAssetValue = benchmarks.get(i).getNetAssetValue();
			double holdingValueExpected = (netPortfolioAssetValue * perNetAssetValue) / 100;
			double holdingValuePresent = portfolios.get(i).getValue();
			double holdingValueDifference = holdingValueExpected
					- holdingValuePresent;
			double quantity = holdingValueDifference
					/ portfolios.get(i).getPrice();
			quantity = Math.round(quantity * 100.0) / 100.0;
			if (holdingValueDifference <= 0) {

				transaction = new Transaction(SELL, portfolios.get(i)
						.getTicker(), quantity);
			} else {
				transaction = new Transaction(BUY, portfolios.get(i)
						.getTicker(), quantity);
			}
			transactions.add(transaction);

		}

		return transactions;

	}

	static ArrayList<PortfolioHolding> getHoldings(String portfolioString) {
		ArrayList<PortfolioHolding> holdings = new ArrayList<PortfolioHolding>();
		int lastIndex = 0;
		for (int i = 0; i < portfolioString.length(); i++) {
			String temp = String.valueOf(portfolioString.charAt(i));
			if (SEPARATOR.equals(temp)) {
				holdings.add(getHolding(portfolioString, lastIndex, i));
				lastIndex = i + 1;
			}
		}
		holdings.add(getHolding(portfolioString, lastIndex,
				portfolioString.length()));
		return holdings;
	}

	static PortfolioHolding getHolding(String portfolioString, int start,
			int end) {
		String temp = portfolioString.substring(start, end);
		String split[] = temp.split(",");
		PortfolioHolding holding = new PortfolioHolding(split[0], split[1],
				Double.parseDouble(split[2]), split.length == 3 ? 0
						: Double.parseDouble(split[3]));
		return holding;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String res;
		String _input;
		try {
			_input = in.nextLine();
		} catch (Exception e) {
			_input = null;
		}
		res = printHoldingsWithWeight(_input);
		System.out.println(res);
	}
}

class PortfolioHolding {
	private String ticker;

	private String name;

	private double quantity;

	private double price;

	private double value;

	private double netAssetValue;

	public PortfolioHolding(String ticker, String name, double quantity,
			double price) {
		this.ticker = ticker;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public PortfolioHolding(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public String getTicker() {
		return ticker;

	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(double netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	public static Comparator<PortfolioHolding> PortfolioHoldingComparator = new Comparator<PortfolioHolding>() {

		public int compare(PortfolioHolding holding1, PortfolioHolding holding2) {
			String holding1Ticker = holding1.getTicker().toUpperCase();
			String hodlding2Ticker = holding2.getTicker().toUpperCase();
			return holding1Ticker.compareTo(hodlding2Ticker);
		}
	};
}

class Transaction {
	private String type;

	private String ticker;

	private double quantity;

	public Transaction(String type, String ticker, String string) {

		this.ticker = ticker;
		this.type = type;
		this.quantity = string;

	}

	public String getTicker() {
		return ticker;

	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public static Comparator<Transaction> TransactionComparator = new Comparator<Transaction>() {

		public int compare(Transaction transaction1, Transaction transaction2) {
			String transaction1Ticker = transaction1.getTicker().toUpperCase();
			String transaction2Ticker = transaction2.getTicker().toUpperCase();
			return transaction1Ticker.compareTo(transaction2Ticker);
		}
	};
}
