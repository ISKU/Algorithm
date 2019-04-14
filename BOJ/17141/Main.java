/*
 * Author: Minho Kim (ISKU)
 * Date: April 14, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17141
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };

	private static List<Point> virus;
	private static int[][] map;
	private static int[] candidate;
	private static int N, M, zero, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		virus = new ArrayList<Point>();
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 0 || map[y][x] == 2)
					zero++;
				if (map[y][x] == 2)
					virus.add(new Point(y, x));
			}
		}

		candidate = new int[M];
		answer = Integer.MAX_VALUE;
		combination(0, 0);

		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void combination(int idx, int n) {
		if (idx == M) {
			answer = Math.min(answer, bfs());
			return;
		}

		for (int i = n; i < virus.size(); i++) {
			candidate[idx] = i;
			combination(idx + 1, i + 1);
		}
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			Point p = virus.get(candidate[i]);
			q.add(new Point(p.y, p.x));
			visited[p.y][p.x] = true;
		}

		int time = -1;
		int count = 0;
		while (!q.isEmpty()) {
			time++;
			if (answer <= time)
				return Integer.MAX_VALUE;

			for (int size = q.size(); size > 0; size--) {
				Point p = q.poll();
				count++;

				for (int i = 0; i < 4; i++) {
					int y = p.y + dy[i];
					int x = p.x + dx[i];
					if (y < 0 || y >= N || x < 0 || x >= N || visited[y][x] || map[y][x] == 1)
						continue;

					q.add(new Point(y, x));
					visited[y][x] = true;
				}
			}
		}

		if (zero != count)
			return Integer.MAX_VALUE;
		return time;
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}