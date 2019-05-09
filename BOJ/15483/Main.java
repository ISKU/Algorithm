/*
 * Author: Minho Kim (ISKU)
 * Date: May 9, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15483
 */

import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		int N = first.length();
		int M = second.length();

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			dp[i][0] = i;
		for (int i = 1; i <= M; i++)
			dp[0][i] = i;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}

		System.out.print(dp[N][M]);
	}
}