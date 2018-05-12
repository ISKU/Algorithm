/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15710
 */

import java.util.*;

public class Main {

	private static final int MOD = (int) 1e9 + 7;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long N = sc.nextLong() - 1;

		long e = 2;
		long n = 1;
		while (N > 0) {
			if ((N & 1) == 1)
				n = (n * e) % MOD;
			N /= 2;
			e = (e * e) % MOD;
		}

		long answer = 1;
		for (int i = 1; i <= 31; i++)
			answer = (answer * n) % MOD;

		System.out.print(answer);
	}
}