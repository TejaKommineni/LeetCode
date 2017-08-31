package LeetCode.Hashing;

public class PrimeNumbersLessThanN {

	
public int countPrimes(int n) {
        
        boolean[] primes = new boolean[n];
        
        for(int i=2;i<=primes.length/2;i++)
        {
            if(!primes[i])
            {
                int j=2;
                while(i*j <=n)
                {
                    primes[i*j] = true;
                    j++;
                }
            }
        }
        int count =0;
        for(int i=2;i<primes.length;i++)
        {
            if(!primes[i])
            count++;
        }
       return count; 
        
    }
public static void main(String[] args) {
	PrimeNumbersLessThanN p = new PrimeNumbersLessThanN();
	p.countPrimes(5);
} 
}
