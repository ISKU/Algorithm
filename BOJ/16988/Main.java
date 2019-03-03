/*
 * Author: Minho Kim (ISKU)
 * Date: March 2, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16988
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 0, 1, 0 };
	public static final int[] dx = new int[] { 0, 1, 0, -1 };

	private static int[][] map;
	private static boolean[][] visited;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Point> list = new ArrayList<>();
		map = new int[N + 2][M + 2];
		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				list.add(new Point(y, x));
			}
		}
		for (int y = 0; y <= N + 1; y++) {
			map[y][0] = 1;
			map[y][M + 1] = 1;
		}
		for (int x = 0; x <= M + 1; x++) {
			map[0][x] = 1;
			map[N + 1][x] = 1;
		}

		int answer = 0;
		for (int i = 0; i < list.size(); i++) {
			Point first = list.get(i);
			if (map[first.y][first.x] != 0)
				continue;

			for (int j = i + 1; j < list.size(); j++) {
				Point second = list.get(j);
				if (map[second.y][second.x] != 0)
					continue;

				map[first.y][first.x] = 1;
				map[second.y][second.x] = 1;

				int count = 0;
				visited = new boolean[N + 2][M + 2];
				for (int y = 1; y <= N; y++)
					for (int x = 1; x <= M; x++)
						if (!visited[y][x] && map[y][x] == 2)
							count += bfs(y, x);

				answer = Math.max(answer, count);
				map[first.y][first.x] = 0;
				map[second.y][second.x] = 0;
			}
		}

		System.out.println(answer);
	}

	private static int bfs(int sy, int sx) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sy, sx));
		visited[sy][sx] = true;

		boolean check = false;
		int count = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			count++;

			for (int i = 0; i < 4; i++) {
				int y = p.y + dy[i];
				int x = p.x + dx[i];
				if (visited[y][x] || map[y][x] == 1)
					continue;
				if (map[y][x] == 0) {
					check = true;
					continue;
				}

				visited[y][x] = true;
				q.add(new Point(y, x));
			}
		}

		return (check) ? 0 : count;
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}