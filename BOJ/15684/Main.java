/*
 * Author: Minho Kim (ISKU)
 * Date: April 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15684
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int H, N, M;
	private static boolean[][] map;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new boolean[H + 2][N * 2 + 1];
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) * 2] = true;
		}

		for (int i = 0; i <= 3; i++)
			dfs(0, 0, i);

		System.out.print(-1);
	}

	private static void dfs(int n, int idx, int round) {
		if (n == round) {
			if (run()) {
				System.out.print(n);
				System.exit(0);
			}
			return;
		}

		for (int i = idx + 1; i <= H * N; i++) {
			int y = (i - 1) / N + 1;
			int x = (i - (y - 1) * N) * 2;

			if (x != N * 2 && !map[y][x] && !map[y][x - 2] && !map[y][x + 2]) {
				map[y][x] = true;
				dfs(n + 1, i, round);
				map[y][x] = false;
			}
		}
	}

	private static boolean run() {
		for (int i = 1; i < N * 2; i += 2)
			if (i != run(1, i))
				return false;
		return true;
	}

	private static int run(int y, int x) {
		if (y == H + 1)
			return x;

		if (map[y][x - 1])
			return run(y + 1, x - 2);
		else if (map[y][x + 1])
			return run(y + 1, x + 2);
		else
			return run(y + 1, x);
	}
}