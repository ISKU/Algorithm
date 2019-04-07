/*
 * Author: Minho Kim (ISKU)
 * Date: April 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17136
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int N = 10;
	private static List<Point> points;
	private static boolean[][] map, visited;
	private static int[][] dp;
	private static int[] block;
	private static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		points = new ArrayList<Point>();
		map = new boolean[N + 1][N + 1];
		for (int y = 1; y <= N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= N; x++) {
				map[y][x] = (Integer.parseInt(st.nextToken()) == 1) ? true : false;
				if (map[y][x])
					points.add(new Point(y, x));
			}
		}
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o2.y == o1.y)
					return Integer.compare(o2.x, o1.x);
				return Integer.compare(o2.y, o1.y);
			}
		});

		dp = new int[N + 1][N + 1];
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				if (!map[y][x])
					continue;
				dp[y][x] = Math.min(dp[y - 1][x - 1], Math.min(dp[y - 1][x], dp[y][x - 1])) + 1;
			}
		}

		answer = Integer.MAX_VALUE;
		visited = new boolean[N + 1][N + 1];
		block = new int[] { 0, 5, 5, 5, 5, 5 };
		dfs(0, 0);

		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void dfs(int idx, int count) {
		if (idx == points.size()) {
			boolean check = true;
			for (int i = 0; i < points.size(); i++) {
				Point p = points.get(i);
				if (!visited[p.y][p.x]) {
					check = false;
					break;
				}
			}

			if (check)
				answer = Math.min(answer, count);
			return;
		}
		if (answer < count)
			return;

		Point p = points.get(idx);
		if (visited[p.y][p.x]) {
			dfs(idx + 1, count);
			return;
		}

		for (int n = dp[p.y][p.x]; n >= 1; n--) {
			if (n > 5)
				continue;
			if (block[n] == 0)
				return;
			if (!possible(p.y, p.x, n))
				continue;

			fill(p.y, p.x, n);
			block[n]--;

			dfs(idx + 1, count + 1);

			revert(p.y, p.x, n);
			block[n]++;
		}
	}

	private static boolean possible(int y, int x, int n) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (visited[y - i][x - j])
					return false;

		return true;
	}

	private static void fill(int y, int x, int n) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				visited[y - i][x - j] = true;
	}

	private static void revert(int y, int x, int n) {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				visited[y - i][x - j] = false;
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}