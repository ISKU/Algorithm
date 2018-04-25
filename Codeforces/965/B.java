/*
 * Author: Minho Kim (ISKU)
 * Date: April 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/965/B
 */

import java.util.*;
import java.io.*;

public class B {

	private static char[][] map;
	private static int[][] cell;
	private static int N, K;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cell = new int[N][N];
		map = new char[N][N];
		for (int y = 0; y < N; y++)
			map[y] = br.readLine().toCharArray();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int offset = dfs(y, x, 0, false);
				if (offset >= K) {
					int count = offset - K + 1;
					for (int i = x, k = 1; k <= count; i++, k++)
						for (int j = i; j < i + K; j++)
							cell[y][j]++;
				}
				x += offset;
			}
		}

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				int offset = dfs(y, x, 0, true);
				if (offset >= K) {
					int count = offset - K + 1;
					for (int i = y, k = 1; k <= count; i++, k++)
						for (int j = i; j < i + K; j++)
							cell[j][x]++;
				}
				y += offset;
			}
		}

		int Y = 0;
		int X = 0;
		int max = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (max < cell[y][x]) {
					Y = y;
					X = x;
					max = cell[y][x];
				}
			}
		}

		System.out.printf("%d %d", Y + 1, X + 1);
	}

	private static int dfs(int y, int x, int n, boolean D) {
		if (y >= N || x >= N || map[y][x] == '#')
			return n;
		return dfs((D ? y + 1 : y), (D ? x : x + 1), n + 1, D);
	}
}