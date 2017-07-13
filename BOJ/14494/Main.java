/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14494
 */

import java.util.Scanner;

public class Main {

	private static final long MOD = 1000000007;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		long[][] table = new long[n][m];

		table[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i - 1 >= 0)
					table[i][j] += table[i - 1][j] % MOD;
				if (j - 1 >= 0)
					table[i][j] += table[i][j - 1] % MOD;
				if (i - 1 >= 0 && j - 1 >= 0)
					table[i][j] += table[i - 1][j - 1] % MOD;
			}
		}

		System.out.print(table[n - 1][m - 1] % MOD);
	}
}
