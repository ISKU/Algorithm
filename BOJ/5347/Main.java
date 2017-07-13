/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5347
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--)
			System.out.println(LCM(input.nextLong(), input.nextLong()));
	}

	private static long LCM(long first, long second) {
		long firstNumber = first;
		long secondNumber = second;
		long temp;

		while (second != 0) {
			temp = first % second;
			first = second;
			second = temp;
		}

		return firstNumber * secondNumber / first;
	}
}