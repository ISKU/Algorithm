/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.08
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12037
 */

import java.util.Scanner;

public class Main {

	public static final long MODULAR = 1000000007;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			int C = input.nextInt();
			int V = input.nextInt();
			int L = input.nextInt();

			long[][] table = new long[L + 1][C + V];
			table[0][C + V - 1] = 1;
			for (int i = 1; i <= L; i++)
				for (int j = 0; j < C + V; j++)
					for (int k = 0; k < C + V; k++) {
						if (j < C && k < C)
							continue;
						table[i][k] = (table[i - 1][j] + table[i][k]) % MODULAR;
					}

			long sum = 0;
			for (int i = C; i < C + V; i++)
				sum = (sum + table[L][i]) % MODULAR;

			System.out.printf("Case #%d: %d\n", tCase, sum);
		}
	}
}