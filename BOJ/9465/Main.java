/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9465
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int N = input.nextInt();
			int[][] sticker = new int[2][100001];
			int[][] dp = new int[2][100001];

			for (int i = 0; i < 2; i++)
				for (int j = 1; j <= N; j++)
					sticker[i][j] = input.nextInt();

			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			dp[0][2] = Math.max(dp[0][1], sticker[0][2] + dp[1][1]);
			dp[1][2] = Math.max(dp[1][1], sticker[1][2] + dp[0][1]);
			for (int i = 3; i <= N; i++) {
				dp[0][i] = Math.max(dp[0][i - 1], sticker[0][i] + dp[1][i - 1]);
				dp[0][i] = Math.max(dp[0][i], sticker[0][i] + dp[1][i - 2]);
				dp[1][i] = Math.max(dp[1][i - 1], sticker[1][i] + dp[0][i - 1]);
				dp[1][i] = Math.max(dp[1][i], sticker[1][i] + dp[0][i - 2]);
			}

			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}