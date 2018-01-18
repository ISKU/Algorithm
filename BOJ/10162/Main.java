/*
 * Author: Minho Kim (ISKU)
 * Date: January 18, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10162
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int T = new Scanner(System.in).nextInt();
		int[] button = new int[] { 300, 60, 10 };
		int[] ans = new int[3];

		for (int i = 0; i < 3; i++) {
			ans[i] = T / button[i];
			T %= button[i];
		}

		if (T > 0)
			System.out.print(-1);
		else
			System.out.printf("%d %d %d", ans[0], ans[1], ans[2]);
	}
}