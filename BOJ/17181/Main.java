/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17181
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };
	private static int[][] map;
	private static int[][][] dp;
	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		map = new int[Y][X];
		dp = new int[Y][X][3];
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[y][x], Integer.MAX_VALUE);
			}
		}

		if (map[0][0] <= 13)
			dfs(0, 0, 0, 0);
		int answer = Math.min(dp[Y - 1][X - 1][1], dp[Y - 1][X - 1][2]);
		System.out.print((answer == Integer.MAX_VALUE) ? "BAD" : answer);
	}

	private static void dfs(int y, int x, int status, int count) {
		if (dp[y][x][status] <= count)
			return;
		dp[y][x][status] = count;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= Y || nx < 0 || nx >= X)
				continue;

			if (status == 0 && map[ny][nx] >= 14)
				dfs(ny, nx, 1, count + 1);
			if (status == 1 && map[ny][nx] <= 13) {
				dfs(ny, nx, 2, count);
				dfs(ny, nx, 0, count);
			}
			if (status == 2 && map[ny][nx] <= 13)
				dfs(ny, nx, 0, count);
		}
	}
}