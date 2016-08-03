/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2908
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println(Math.max(reverseNumber(input.nextInt()), reverseNumber(input.nextInt())));
	}

	private static int reverseNumber(int number) {
		int reverseNumber = 0;

		for (int divisor = 100, multiplier = 1; multiplier <= 100; divisor /= 10, multiplier *= 10) {
			reverseNumber += (number / divisor) * multiplier;
			number = number % divisor;
		}
		return reverseNumber;
	}
}