/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2294
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for (int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[K + 1];
		Arrays.fill(dp, 1, K + 1, 100001);
		for (int i = 0; i < N; i++)
			for (int j = coins[i]; j <= K; j++)
				dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);

		System.out.print((dp[K] == 100001) ? -1 : dp[K]);
	}
}