package Contests;

public class Contest33 {
    public String fractionAddition(String expression) {
        int aNumerator = 0;
        int aDenominator = 1;
        int aSign = 1;
        int bNumerator = 0;
        int bDenominator = 0;
        int bSign = 1;
        if(expression.charAt(0) != '-')
        {
           expression = "+" + expression;
        }
        for(int i=0;i<expression.length();)
        {
            if(expression.charAt(i)== '+')
            bSign = 1;
            else
            bSign = -1;
            
            i++;
            while(expression.charAt(i)-'0' <= 9 && expression.charAt(i)-'0' >=0 )
            {
               bNumerator = bNumerator * 10 + expression.charAt(i)-'0';
               i++;
            }
            i++;
            while(i<expression.length() && expression.charAt(i)-'0' <= 9 && expression.charAt(i)-'0' >=0 )
            {
               bDenominator = bDenominator * 10 + expression.charAt(i)-'0';
               i++;
            }
            
           
            aNumerator =  aSign * aNumerator * bDenominator + bSign * aDenominator * bNumerator;
            aDenominator = aDenominator * bDenominator;
            aSign = aNumerator>=0?1:-1;
            aNumerator = Math.abs(aNumerator);
            bNumerator =0;
            bDenominator = 0; 
            System.out.println(aNumerator + " " + aDenominator );
        }
       
        while(true)
        {
            int remainder = gcd(aNumerator,aDenominator);
            if(remainder == 1)
            break;
            
            aNumerator = aNumerator/remainder;
            aDenominator = aDenominator/remainder;
        }
        
        if(aSign == -1) 
        return "-"+aNumerator +"/"+  aDenominator;
        else
        return ""+aNumerator +"/"+  aDenominator;
        
    }
    
    int gcd(int a, int b)
    {
        if(b == 0)
        return a;
        else
        return gcd(b,a%b);
    }
    
    public static void main(String[] args) {
    	Contest33 c = new Contest33();
    	c.fractionAddition("-5/2+10/3+7/9");
	}
}
