/*
 * Author: Minho Kim (ISKU)
 * Date: May 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15717
 */

import java.util.*;

public class Main {

	private static final int MOD = (int) 1e9 + 7;

	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong() - 1;

		long e = 2;
		long answer = 1;
		while (N > 0) {
			if ((N & 1) == 1)
				answer = (answer * e) % MOD;
			N /= 2;
			e = (e * e) % MOD;
		}

		System.out.print(answer);
	}
}