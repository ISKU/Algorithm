/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1003
 */

import java.util.Scanner;

public class Main {

	private static int countCallZero = 0;
	private static int countCallOne = 0;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			countCallZero = countCallOne = 0;
			fibonacci(input.nextInt());
			System.out.println(countCallZero + " " + countCallOne);
		}
	}

	private static int fibonacci(int n) {
		if (n == 0) {
			countCallZero++;
			return 0;
		} else if (n == 1) {
			countCallOne++;
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}