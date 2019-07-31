/*
 * Author: Minho Kim (ISKU)
 * Date: July 27, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17370
 */

import java.io.*;

public class Main {

	private static boolean[][] map;
	private static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new boolean[50][50];
		map[25][25] = true;

		dfs(24, 25, 1, 0);
		System.out.println(answer);
	}

	private static void dfs(int y, int x, int dir, int depth) {
		if (depth == N) {
			if (map[y][x])
				answer++;
			return;
		}
		if (map[y][x])
			return;

		if (dir == 1) {
			map[y][x] = true;
			dfs(y - 1, x + 1, 3, depth + 1);
			dfs(y - 1, x - 1, 5, depth + 1);
			map[y][x] = false;
		}
		else if (dir == 2) {
			map[y][x] = true;
			dfs(y + 1, x + 1, 4, depth + 1);
			dfs(y + 1, x - 1, 6, depth + 1);
			map[y][x] = false;
		}
		else if (dir == 3) {
			map[y][x] = true;
			dfs(y - 1, x, 1, depth + 1);
			dfs(y + 1, x + 1, 4, depth + 1);
			map[y][x] = false;
		}
		else if (dir == 4) {
			map[y][x] = true;
			dfs(y + 1, x, 2, depth + 1);
			dfs(y - 1, x + 1, 3, depth + 1);
			map[y][x] = false;
		}
		else if (dir == 5) {
			map[y][x] = true;
			dfs(y - 1, x, 1, depth + 1);
			dfs(y + 1, x - 1, 6, depth + 1);
			map[y][x] = false;
		}
		else {
			map[y][x] = true;
			dfs(y + 1, x, 2, depth + 1);
			dfs(y - 1, x - 1, 5, depth + 1);
			map[y][x] = false;
		}
	}
}