package LeetCode.General;

class CalculationException extends Exception {
	String message;

	public CalculationException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

class LessThanZeroException extends CalculationException {

	public LessThanZeroException(String message) {
		super(message);
	}

}

class GreaterThanThresholdException extends CalculationException {

	public GreaterThanThresholdException(String message) {
		super(message);
	}

}

class AdditionException extends CalculationException {

	public AdditionException(String message) {
		super(message);
	}

}

class SubtractionException extends CalculationException {

	public SubtractionException(String message) {
		super(message);
	}

}

class MultiplicationException extends CalculationException {

	public MultiplicationException(String message) {
		super(message);
	}

}

class DivisionException extends CalculationException {

	public DivisionException(String message) {
		super(message);
	}

}

class NumericStringExpectedException extends CalculationException {

	public NumericStringExpectedException(String message) {
		super(message);
	}

}

public class Calculator {

	public double calculateAM(String args[]) throws CalculationException {
		double sum = 0;
		for (int i = 0; i < args.length; i++) {
			try {
				sum = sum + Double.parseDouble(args[i]);
			} catch (NumberFormatException e) {
				throw new NumericStringExpectedException("Please Enter a valid numerical value.");
			} catch (NullPointerException e) {
				throw new NumericStringExpectedException(
						"Please Enter a valid numerical value the entered value is null.");
			}
		}
		return sum / args.length;

	}

	public double calculateGM(String args[]) throws CalculationException {
		double sum = 1;
		for (int i = 0; i < args.length; i++) {
			try {
				sum = sum * Double.parseDouble(args[i]);
			} catch (NumberFormatException e) {
				throw new NumericStringExpectedException("Please Enter a valid numerical value.");
			} catch (NullPointerException e) {
				throw new NumericStringExpectedException(
						"Please Enter a valid numerical value the entered value is null.");
			} catch (Exception e) {
				throw new NumericStringExpectedException("Overflow exception");
			}
		}
		return Math.pow(sum, 1.0 / args.length);

	}

	public double calculate(String a, String b, String operator) throws CalculationException {
		double x = Double.parseDouble(a);
		double y = Double.parseDouble(b);
		double ans = 0;
		try {
			if (operator.equals("/")) {
				if (x / y < 0)
					throw new LessThanZeroException("The value is less than zero");
				return x / y;
			}
		} catch (LessThanZeroException e) {
			throw e;
		} catch (Exception e) {

			throw new DivisionException("There is a issue with division.");
		}
		try {
			if (operator.equals("*")) {
				if (x * y > 100)
					throw new GreaterThanThresholdException("The value is greater than 100");
				else
					return x * y;

			}
		} catch (GreaterThanThresholdException e) {
			throw e;
		} catch (Exception e) {
			throw new SubtractionException("There is a issue with subtraction.");
		}
		try {
			if (operator.equals("+")) {
				return x + y;
			}
		} catch (Exception e) {
			throw new AdditionException("There is a issue with addition.");
		}
		try {
			if (operator.equals("-")) {
				return x - y;
			}
		} catch (Exception e) {
			throw new SubtractionException("There is a issue with subtraction.");
		}
		return ans;
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		try {
			System.out.println(c.calculate("200", "100", "/"));
		} catch (CalculationException cs) {
			System.out.println(cs.getMessage());
		}
		try {
			System.out.println(c.calculateAM(new String[] { "100", "100" }));
		} catch (CalculationException cs) {
			System.out.println(cs.getMessage());
		}
		try {
			System.out.println(c.calculateGM(new String[] { "100", "100" }));
		} catch (CalculationException cs) {
			System.out.println(cs.getMessage());
		}
	}
}
