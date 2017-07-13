/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.19
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1924
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		int day = input.nextInt();
		int sumOfDays = day; // initialization, day input value

		// the sum of all the number of days of the month
		for (int countOfMonth = 1; countOfMonth < month; countOfMonth++)
			sumOfDays += getNumberOfDaysInMonth(countOfMonth);

		System.out.println(getDayOfTheWeek(sumOfDays)); // output, day of the week
	}

	// get number of days in a month
	public static int getNumberOfDaysInMonth(int month) {
		switch (month) {
		case 2:
			return 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}

	// get day of the week
	private static String getDayOfTheWeek(int days) {
		switch (days % 7) {
		case 0:
			return "SUN";
		case 1:
			return "MON";
		case 2:
			return "TUE";
		case 3:
			return "WED";
		case 4:
			return "THU";
		case 5:
			return "FRI";
		default:
			return "SAT";
		}
	}
}