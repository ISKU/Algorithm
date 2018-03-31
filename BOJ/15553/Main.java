/*
 * Author: Minho Kim (ISKU)
 * Date: March 31, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15553
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] time = new int[N];
		for (int i = 0; i < N; i++)
			time[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[N];
		for (int i = 1; i < N; i++)
			dp[i] = time[i] - time[i - 1] - 1;
		Arrays.sort(dp);

		int answer = time[N - 1] - time[0] + 1;
		for (int i = N - 1, k = 1; k < K; i--, k++)
			answer -= dp[i];
		System.out.print(answer);
	}
}