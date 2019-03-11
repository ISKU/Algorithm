/*
 * Author: Minho Kim (ISKU)
 * Date: March 11, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17069
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++)
				map[y][x] = (Integer.parseInt(st.nextToken()) == 0) ? true : false;
		}

		long[][][] dp = new long[N][N][3];
		dp[0][1][0] = 1;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (x - 1 >= 0 && dp[y][x - 1][0] > 0 && map[y][x])
					dp[y][x][0] += dp[y][x - 1][0];
				if (y - 1 >= 0 && x - 1 >= 0 && dp[y - 1][x - 1][0] > 0 && map[y][x] && map[y - 1][x] && map[y][x - 1])
					dp[y][x][2] += dp[y - 1][x - 1][0];

				if (y - 1 >= 0 && dp[y - 1][x][1] > 0 && map[y][x])
					dp[y][x][1] += dp[y - 1][x][1];
				if (y - 1 >= 0 && x - 1 >= 0 && dp[y - 1][x - 1][1] > 0 && map[y][x] && map[y - 1][x] && map[y][x - 1])
					dp[y][x][2] += dp[y - 1][x - 1][1];

				if (x - 1 >= 0 && dp[y][x - 1][2] > 0 && map[y][x])
					dp[y][x][0] += dp[y][x - 1][2];
				if (y - 1 >= 0 && dp[y - 1][x][2] > 0 && map[y][x])
					dp[y][x][1] += dp[y - 1][x][2];
				if (y - 1 >= 0 && x - 1 >= 0 && dp[y - 1][x - 1][2] > 0 && map[y][x] && map[y - 1][x] && map[y][x - 1])
					dp[y][x][2] += dp[y - 1][x - 1][2];
			}
		}

		System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
	}
}