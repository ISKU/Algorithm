/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6591
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			long n = input.nextLong();
			long k = input.nextLong();

			if (n == 0 && k == 0)
				break;
			System.out.println(combination(n, k));
		}
	}

	private static long combination(long n, long k) {
		if (k > n / 2)
			k = n - k;

		long result = 1;
		for (int i = 0; i < k; i++)
			result = result * (n - i) / (i + 1);
		return result;
	}
}