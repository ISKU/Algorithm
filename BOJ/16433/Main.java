/*
 * Author: Minho Kim (ISKU)
 * Date: November 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16433
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -1, -1, 1, 1 };
	private static final int[] dx = new int[] { -1, 1, 1, -1 };

	private static boolean[][] map;
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();

		map = new boolean[N + 1][N + 1];
		dfs(R, C);

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++)
				System.out.print(map[y][x] ? 'v' : '.');
			System.out.println();
		}
	}

	private static void dfs(int r, int c) {
		map[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int y = r + dy[i];
			int x = c + dx[i];
			if (y <= 0 || y > N || x <= 0 || x > N || map[y][x])
				continue;

			dfs(y, x);
		}
	}
}