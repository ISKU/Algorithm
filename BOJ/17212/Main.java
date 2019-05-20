/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17212
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] coins = new int[] { 1, 2, 5, 7 };
		int[] dp = new int[N + 1];
		Arrays.fill(dp, 1, N + 1, Integer.MAX_VALUE);
		for (int i = 0; i < 4; i++)
			for (int j = coins[i]; j <= N; j++)
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

		System.out.print(dp[N]);
	}
}