/*
 * Author: Minho Kim (ISKU)
 * Date: August 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15979
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int M = Math.abs(sc.nextInt());
		int N = Math.abs(sc.nextInt());
		int gcd = gcd(M, N);

		System.out.print((gcd == 0) ? 0 : (gcd == 1) ? 1 : 2);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}