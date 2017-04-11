/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10844
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {

	private static final int MOD = 1000000000;

	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int[][] table = new int[N + 1][10];

		Arrays.fill(table[1], 1);
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					table[i][0] = table[i - 1][1] % MOD;
				else if (j == 9)
					table[i][9] = table[i - 1][8] % MOD;
				else
					table[i][j] = (table[i - 1][j - 1] + table[i - 1][j + 1]) % MOD;
			}
		}

		int sum = 0;
		for (int i = 1; i < 10; i++)
			sum = (sum + table[N][i]) % MOD;
		System.out.print(sum % MOD);
	}
}