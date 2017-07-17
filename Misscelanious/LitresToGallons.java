package Misscelanious;

public class LitresToGallons {
	
	private static final double Litre = 4.22675284;
	private static final double SquareFeetToSquareMile = 27878400;
	private static final double SquareFeetToAcres = 640;
	private static final double SquareFeetToSquareRods = 102400;
	
	public double convert(double litres)
	{
			
		double cups = litres *Litre;
		
		double pints = cups*2;
		
		double quarts = pints*2;
		
		double gallons = quarts*4;
		
		// for better understanding above code has been split. without using extra variables we can write it as:
		// return (double) litres *litre*2*2*4;
		System.out.println(gallons);
		return gallons;
	}

	public void conversion(double squarefeet)
	{		
		System.out.println(squarefeet + "corresponds to "+ squarefeet/SquareFeetToSquareMile + " miles.");
		System.out.println(squarefeet + "corresponds to "+ squarefeet/SquareFeetToAcres + " acres.");
		System.out.println(squarefeet + "corresponds to "+ squarefeet/SquareFeetToSquareRods + " rods.");
	}
	
	private static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }
	
	
	public static void main(String[] args) {
		LitresToGallons l = new LitresToGallons();
		l.convert(4);
		l.conversion(25000000);
		System.out.println(l.findGCD(4, 6));
	}
}
