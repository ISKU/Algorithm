/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3036
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int first = input.nextInt();

		for (int i = 1; i < n; i++) {
			int ring = input.nextInt();
			int gcd = gcd(first, ring);
			System.out.printf("%d/%d\n", first / gcd, ring / gcd);
		}
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}