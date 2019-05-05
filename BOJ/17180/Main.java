/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17180
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[] first = br.readLine().toCharArray();
		char[] second = br.readLine().toCharArray();

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++)
			dp[i][0] = Integer.MAX_VALUE;
		for (int j = 1; j <= M; j++)
			dp[0][j] = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = Math.abs(first[i - 1] - second[j - 1]);
				dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
			}
		}

		System.out.print(dp[N][M]);
	}
}