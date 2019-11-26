/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18128
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	public static final int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };

	private static char[][] map;
	private static int[][] water;
	private static int N, W;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new LinkedList<>();
		water = new int[N][N];
		while (W-- > 0) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			water[y][x] = 1;
			q.add(new int[] { y, x });
		}
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int py = p[0];
			int px = p[1];
			int day = water[py][px];

			for (int i = 0; i < 4; i++) {
				int y = py + dy[i];
				int x = px + dx[i];
				if (y < 0 || y >= N || x < 0 || x >= N || water[y][x] > 0)
					continue;

				water[y][x] = day + 1;
				q.add(new int[] { y, x });
			}
		}

		map = new char[N][];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		int l = 1;
		int r = 2 * N;
		while (l < r) {
			int mid = (l + r) / 2;

			if (bfs(mid))
				r = mid;
			else
				l = mid + 1;
		}

		System.out.println((l == 2 * N) ? -1 : l - 1);
	}

	private static boolean bfs(int day) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int py = p[0];
			int px = p[1];

			for (int i = 0; i < 8; i++) {
				int y = py + dy[i];
				int x = px + dx[i];
				if (y < 0 || y >= N || x < 0 || x >= N)
					continue;
				if (visited[y][x] || map[y][x] == '0')
					continue;
				if (y == N - 1 && x == N - 1)
					return true;
				if (water[y][x] > day)
					continue;

				visited[y][x] = true;
				q.add(new int[] { y, x });
			}
		}

		return false;
	}
}
