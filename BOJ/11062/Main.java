/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11062
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int[] cards = new int[input.nextInt() + 1];
			for (int i = 1; i < cards.length; i++)
				cards[i] = input.nextInt();

			int[] sum = new int[cards.length];
			int[][] dp = new int[cards.length][cards.length];

			for (int i = 1; i < sum.length; i++) {
				sum[i] = sum[i - 1] + cards[i];
				dp[i][i] = cards[i];
			}

			for (int k = 1; k <= cards.length - 2; k++)
				for (int i = 1; i <= cards.length - 1 - k; i++)
					dp[i][k + i] = sum[k + i] - sum[i - 1] - Math.min(dp[i][k + i - 1], dp[i + 1][k + i]);

			System.out.println(dp[1][cards.length - 1]);
		}
	}
}