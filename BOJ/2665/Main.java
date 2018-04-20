/*
 * Author: Minho Kim (ISKU)
 * Date: April 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2665
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int[] dy = { -1, 0, 1, 0 };
	private static final int[] dx = { 0, 1, 0, -1 };

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[][] map = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			String line = br.readLine();
			for (int x = 0; x < N; x++)
				map[y][x] = (line.charAt(x) == '1') ? true : false;
		}

		int[][] visited = new int[N][N];
		for (int y = 0; y < N; y++)
			Arrays.fill(visited[y], Integer.MAX_VALUE);

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int y = p.y + dy[i];
				int x = p.x + dx[i];
				if (y < 0 || y >= N || x < 0 || x >= N)
					continue;

				if (map[y][x] && visited[p.y][p.x] < visited[y][x]) {
					visited[y][x] = visited[p.y][p.x];
					q.add(new Point(y, x));
				}
				if (!map[y][x] && visited[p.y][p.x] + 1 < visited[y][x]) {
					visited[y][x] = visited[p.y][p.x] + 1;
					q.add(new Point(y, x));
				}
			}
		}

		System.out.print(visited[N - 1][N - 1]);
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}