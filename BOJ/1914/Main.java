/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1914
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	private static int count = 0;
	private static StringBuilder output = new StringBuilder();

	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		if (N <= 20) {
			hanoi(N, 1, 3);
			System.out.println(count);
			System.out.print(output);
		} else
			System.out.print(new BigInteger("2").pow(N).subtract(BigInteger.ONE));
	}

	private static void hanoi(int n, int a, int b) {
		if (n == 1)
			output.append(String.format("%d %d\n", a, b));
		else {
			int temp = 6 - a - b;
			hanoi(n - 1, a, temp);
			output.append(String.format("%d %d\n", a, b));
			hanoi(n - 1, temp, b);
		}

		count++;
	}
}