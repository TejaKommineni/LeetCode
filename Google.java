package LeetCode;

import java.util.Arrays;

public class Google {
	
	public static void main(String[] args) {
		System.out.println("Result is: " + new Google().solution("11:00"));
	}

	public String solution(String s) {
		String[] tokens = s.split(":");
		int min = (Character.digit(tokens[1].charAt(0), 10) * 10) + (Character.digit(tokens[1].charAt(1), 10));
		int hour = (Character.digit(tokens[0].charAt(0), 10) * 10) + (Character.digit(tokens[0].charAt(1), 10));
		if (hour > 23 || min > 59) {
			return "";
		}

		char[] givenTime = s.toCharArray();
		Arrays.sort(givenTime);
		
		int nextMin = min;
		int nextHour = hour;
		for (int i = 0; i < 3600; i++) {
			nextMin = incrementMins(nextMin);
			if (nextMin == 0) {
				nextHour = incrementHours(nextHour);
			}
			
			if(check(nextHour, nextMin, givenTime)) {
				return constructTimeWithoutRepetition(nextHour, nextMin);
			}
		}
		return "";
	}
	
	private boolean check(int nextHour, int nextMin, char[] givenTime) {
		String nextTime = constructTimeWithoutRepetition(nextHour, nextMin);
		char[] second = nextTime.toCharArray();
		Arrays.sort(second);
		return Arrays.equals(givenTime, second);

	}

	private String constructTimeWithoutRepetition(int nextHour, int nextMin) {
		String min = Integer.toString(nextMin);
		String hour = Integer.toString(nextHour);
		if (min.length() < 2) {
			min = '0' + min;
		}
		if (hour.length() < 2) {
			hour = '0' + hour;
		}
		return hour + ":" + min;
	}

	private int incrementMins(int min) {
		int digit1 = min / 10;
		int digit0 = min % 10;

		if (digit0 < 9) {
			digit0++;
		} else {
			digit0 = 0;
			if (digit1 < 5) {
				digit1++;
			} else {
				digit1 = 0;
			}
		}

		return digit1 * 10 + digit0;
	}

	private int incrementHours(int hour) {
		int digit1 = hour / 10;
		int digit0 = hour % 10;

		if (digit0 < 3) {
			digit0++;
		} else if (digit0 < 9 && digit1 < 2) {
			digit0++;
		} else {
			digit0 = 0;
			if (digit1 < 2) {
				digit1++;
			} else {
				digit1 = 0;
			}
		}
		return digit1 * 10 + digit0;
	}
}
