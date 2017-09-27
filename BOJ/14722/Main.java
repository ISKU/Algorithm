/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.27
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14722
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] milks = new int[] { 0, 1, 2 };
		int[][] graph = new int[N][N];
		int[][][] dp = new int[N + 1][N + 1][3];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				graph[i][j] = input.nextInt();

		for (int i = N - 1; i >= 0; i--)
			for (int j = N - 1; j >= 0; j--)
				for (int milk : milks)
					if (graph[i][j] != milk)
						dp[i][j][milk] = Math.max(dp[i + 1][j][milk], dp[i][j + 1][milk]);
					else
						dp[i][j][milk] = 1 + Math.max(dp[i + 1][j][(milk + 1) % 3], dp[i][j + 1][(milk + 1) % 3]);

		System.out.print(dp[0][0][0]);
	}
}