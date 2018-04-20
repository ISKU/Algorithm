/*
 * Author: Minho Kim (ISKU)
 * Date: April 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1652
 */

import java.util.*;

public class Main {

	private static int N;
	private static boolean[][] room;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		room = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			String line = sc.next();
			for (int x = 0; x < N; x++)
				room[y][x] = (line.charAt(x) == '.') ? true : false;
		}

		int row = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int n = dfs(y, x, 0, false);
				if (n >= 2)
					row++;
				x += n;
			}
		}

		int column = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				int n = dfs(y, x, 0, true);
				if (n >= 2)
					column++;
				y += n;
			}
		}

		System.out.printf("%d %d", row, column);
	}

	private static int dfs(int y, int x, int n, boolean dir) {
		if (y < 0 || y >= N || x < 0 || x >= N || !room[y][x])
			return n;
		return dfs((dir ? y + 1 : y), (!dir ? x + 1 : x), n + 1, dir);
	}
}