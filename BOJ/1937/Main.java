/*
 * Author: Minho Kim (ISKU)
 * Date: October 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1937
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };
	private static int[][] map, dp;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N][N];
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				max = Math.max(max, dfs(y, x));

		System.out.print(max);
	}

	private static int dfs(int y, int x) {
		if (dp[y][x] != 0)
			return dp[y][x];

		dp[y][x] = 1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				continue;

			if (map[y][x] < map[ny][nx])
				dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
		}

		return dp[y][x];
	}
}