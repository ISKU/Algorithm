/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13420
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			long a = input.nextLong();
			String op = input.next();
			long b = input.nextLong();
			input.next();
			long result = input.nextLong();

			System.out.println(get(op, a, b) == result ? "correct" : "wrong answer");
		}
	}

	private static long get(String op, long a, long b) {
		switch (op) {
		case "*":
			return a * b;
		case "/":
			return a / b;
		case "+":
			return a + b;
		case "-":
			return a - b;
		default:
			return 0;
		}
	}
}