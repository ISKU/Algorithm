/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1912
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		int max = Integer.MIN_VALUE;
		dp[0] = array[0];
		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
			max = Math.max(max, dp[i]);
		}

		System.out.print(Math.max(max, dp[0]));
	}
}