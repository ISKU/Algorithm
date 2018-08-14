/*
 * Author: Minho Kim (ISKU)
 * Date: August 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3187
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };

	private static char[][] map;
	private static boolean[][] visited;
	private static int N, M, V, K;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int y = 0; y < N; y++)
			map[y] = br.readLine().toCharArray();

		visited = new boolean[N][M];
		for (int y = 0; y < N; y++)
			for (int x = 0; x < M; x++)
				if (!visited[y][x] && map[y][x] != '#')
					bfs(y, x);

		System.out.printf("%d %d", K, V);
	}

	private static void bfs(int cy, int cx) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(cy, cx));
		visited[cy][cx] = true;

		int v = 0;
		int k = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (map[p.y][p.x] == 'v')
				v++;
			if (map[p.y][p.x] == 'k')
				k++;

			for (int i = 0; i < 4; i++) {
				int y = p.y + dy[i];
				int x = p.x + dx[i];
				if (y < 0 || y >= N || x < 0 || x >= M)
					return;

				if (!visited[y][x] && map[y][x] != '#') {
					visited[y][x] = true;
					q.add(new Point(y, x));
				}
			}
		}

		V += (v >= k) ? v : 0;
		K += (v < k) ? k : 0;
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}