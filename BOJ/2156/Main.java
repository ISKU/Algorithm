/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2156
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] juice = new int[10001];
		int[] dp = new int[10001];

		for (int i = 1; i <= N; i++)
			juice[i] = input.nextInt();

		dp[1] = juice[1];
		dp[2] = juice[1] + juice[2];
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], juice[i] + dp[i - 2]);
			dp[i] = Math.max(dp[i], juice[i] + juice[i - 1] + dp[i - 3]);
		}

		System.out.println(dp[N]);
	}
}