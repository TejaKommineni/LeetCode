package LeetCode.General;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RichieRich {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String number = in.next();
		BigInteger output = new BigInteger("0");
		boolean flag = false;

		if(k>=n)
		{
			String x="";
			
			while(n>0)
			{
				x=x+'9';
				n--;
			}
			
			output= new BigInteger(x);
			System.out.println(output);
		}
		
		else
		{
		
		for (int i = 0, j = number.length() - 1; j > i; i++, j--) {
			if ((number.charAt(i) - '0') > (number.charAt(j) - '0')) {
				if (k <= 0) {
					flag = true;
					break;
				}
				BigInteger bi1 = new BigInteger("10");
				BigInteger bi2 = new BigInteger(
						String.valueOf(number.charAt(i)));

				BigInteger firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				BigInteger secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.add(firstHalf.add(secondHalf));
				k--;
			}

			else if ((number.charAt(i) - '0') < (number.charAt(j) - '0')) {
				if (k <= 0) {
					flag = true;
					break;
				}

				BigInteger bi1 = new BigInteger("10");
				BigInteger bi2 = new BigInteger(
						String.valueOf(number.charAt(j)));

				BigInteger firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				BigInteger secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.add(firstHalf.add(secondHalf));
				k--;

			} else {

				BigInteger bi1 = new BigInteger("10");
				BigInteger bi2 = new BigInteger(
						String.valueOf(number.charAt(i)));
				BigInteger firstHalf = bi1.pow((number.length() - i - 1));
				BigInteger bi3 = new BigInteger(
						String.valueOf(number.charAt(j)));
				firstHalf = firstHalf.multiply(bi2);
				BigInteger secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi3);

				output = output.add(firstHalf.add(secondHalf));

			}

		}

		for (int i = 0, j = number.length() - 1; j > i && k > 0; i++, j--) {
			if ((number.charAt(i) - '0') > (number.charAt(j) - '0')) {
				k = k + 1;

				
				BigInteger bi1 = new BigInteger("10");
				BigInteger bi2 = new BigInteger(
						String.valueOf(number.charAt(i)));

				BigInteger firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				BigInteger secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.subtract(firstHalf.add(secondHalf));
				
				 bi2 = new BigInteger(
						String.valueOf("9"));

				firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.add(firstHalf.add(secondHalf));				
				
				
			}
			if ((number.charAt(i) - '0') < (number.charAt(j) - '0')) {
				k = k + 1;
				

				BigInteger bi1 = new BigInteger("10");
				BigInteger bi2 = new BigInteger(
						String.valueOf(number.charAt(j)));

				BigInteger firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				BigInteger secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.subtract(firstHalf.add(secondHalf));
				
				 bi2 = new BigInteger(
						String.valueOf("9"));

				firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.add(firstHalf.add(secondHalf));		

				k = k - 2;
			}

		}

		for (int i = 0, j = number.length() - 1; j > i && k > 0; i++, j--) {
			if ((number.charAt(i) - '0') == (number.charAt(j) - '0')
					&& (number.charAt(j) - '0') != 9 && k - 2 >= 0) {


				BigInteger bi1 = new BigInteger("10");
				BigInteger bi2 = new BigInteger(
						String.valueOf(number.charAt(i)));

				BigInteger firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				BigInteger secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.subtract(firstHalf.add(secondHalf));
				
				 bi2 = new BigInteger(
						String.valueOf("9"));

				firstHalf = bi1.pow((number.length() - i - 1));
				firstHalf = firstHalf.multiply(bi2);

				secondHalf = bi1.pow((number.length() - j - 1));
				secondHalf = secondHalf.multiply(bi2);

				output = output.add(firstHalf.add(secondHalf));		
				
				k = k - 2;
			}

		}

		if (number.length() % 2 != 0 && k <= 0) {


			BigInteger bi1 = new BigInteger("10");
			BigInteger bi2 = new BigInteger(String.valueOf(number.charAt(number.length() / 2) - '0'));			

			output = output.add(bi1.pow(number.length()- (number.length() / 2) - 1).multiply(bi2));
		
		}

		if (number.length() % 2 != 0 && k > 0) {
			

			BigInteger bi1 = new BigInteger("10");
			BigInteger bi2 = new BigInteger(String.valueOf("9"));			

			output = output.add(bi1.pow(number.length()- (number.length() / 2) - 1).multiply(bi2));

		
		}

		if (flag)
			System.out.println("-1");
		else
			System.out.println(output);

	}

	}}
