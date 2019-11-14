/*
 * Author: Minho Kim (ISKU)
 * Date: November 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://leetcode.com/problems/knight-dialer/
 */

class Solution {

	public static final int MOD = (int) 1E9 + 7;

	public int knightDialer(int N) {
		int[][] dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= N; i++) {
			dp[i][1] = (dp[i - 1][6] + dp[i - 1][8]) % MOD;
			dp[i][2] = (dp[i - 1][7] + dp[i - 1][9]) % MOD;
			dp[i][3] = (dp[i - 1][4] + dp[i - 1][8]) % MOD;
			dp[i][4] = (((dp[i - 1][3] + dp[i - 1][9]) % MOD) + dp[i - 1][0]) % MOD;
			dp[i][6] = (((dp[i - 1][1] + dp[i - 1][7]) % MOD) + dp[i - 1][0]) % MOD;
			dp[i][7] = (dp[i - 1][2] + dp[i - 1][6]) % MOD;
			dp[i][8] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
			dp[i][9] = (dp[i - 1][2] + dp[i - 1][4]) % MOD;
			dp[i][0] = (dp[i - 1][4] + dp[i - 1][6]) % MOD;
		}

		int answer = 0;
		for (int i = 0; i < 10; i++)
			answer = (answer + dp[N][i]) % MOD;
		return answer % MOD;
	}
}
