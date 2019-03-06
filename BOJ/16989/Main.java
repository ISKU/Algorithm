/*
 * Author: Minho Kim (ISKU)
 * Date: March 2, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16989
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] dy = new int[] { -1, 0, 1, 0 };
	public static final int[] dx = new int[] { 0, 1, 0, -1 };

	private static int[][] map, one, two;
	private static boolean[][] visited;
	private static Map<Integer, Integer> twoCount;
	private static Map<Integer, Point[]> twoPoints;
	private static Map<Point, List<Integer>> twoList;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 2][M + 2];
		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= M; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		for (int y = 0; y <= N + 1; y++) {
			map[y][0] = 1;
			map[y][M + 1] = 1;
		}
		for (int x = 0; x <= M + 1; x++) {
			map[0][x] = 1;
			map[N + 1][x] = 1;
		}

		one = new int[N + 2][M + 2];
		two = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];
		twoCount = new HashMap<Integer, Integer>();
		twoPoints = new HashMap<Integer, Point[]>();
		twoList = new HashMap<Point, List<Integer>>();
		int order = 1;
		for (int y = 1; y <= N; y++)
			for (int x = 1; x <= M; x++)
				if (!visited[y][x] && map[y][x] == 2)
					bfs(y, x, order++);

		List<Integer> count = new ArrayList<>();
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				two[y][x] += one[y][x];
				count.add(one[y][x]);
			}
		}
		Collections.sort(count);

		int answer = count.get(N * M - 1) + count.get(N * M - 2);
		for (int y = 1; y <= N; y++)
			for (int x = 1; x <= M; x++)
				answer = Math.max(answer, two[y][x]);

		System.out.println(answer);
	}

	private static void bfs(int sy, int sx, int order) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sy, sx));
		visited[sy][sx] = true;

		List<Point> zero = new ArrayList<>();
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
					visited[y][x] = true;
					zero.add(new Point(y, x));
					continue;
				}

				visited[y][x] = true;
				q.add(new Point(y, x));
			}
		}

		if (zero.size() == 1) {
			Point p = zero.get(0);
			one[p.y][p.x] += count;
		}
		if (zero.size() == 2) {
			Point[] points = zero.toArray(new Point[2]);
			twoCount.put(order, count);
			twoPoints.put(order, points);

			for (Point p : zero) {
				if (!twoList.containsKey(p)) {
					two[p.y][p.x] = Math.max(two[p.y][p.x], count);
					twoList.put(p, new ArrayList<Integer>() {{ add(order); }});
					continue;
				}

				List<Integer> list = twoList.get(p);
				for (int i : list) {
					if (isOverlap(points, twoPoints.get(i)))
						two[p.y][p.x] = Math.max(two[p.y][p.x], twoCount.get(i) + count);
					else
						two[p.y][p.x] = Math.max(two[p.y][p.x], count);
				}
				list.add(order);
			}
		}
		for (Point p : zero)
			visited[p.y][p.x] = false;
	}

	private static boolean isOverlap(Point[] A, Point[] B) {
		return (A[0].equals(B[0]) && A[1].equals(B[1])) || (A[0].equals(B[1]) && A[1].equals(B[0]));
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int hashCode() {
			return this.y * 1009 + this.x;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				if (this.y == p.y && this.x == p.x)
					return true;
			}
			return false;
		}
	}
}