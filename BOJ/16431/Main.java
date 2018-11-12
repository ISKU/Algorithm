/*
 * Author: Minho Kim (ISKU)
 * Date: November 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16431
 */

import java.util.*;

public class Main {

	private static final int[] ny = new int[] { -1, -1, 1, 1 };
	private static final int[] nx = new int[] { -1, 1, 1, -1 };
	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point B = new Point(sc.nextInt(), sc.nextInt(), 0);
		Point D = new Point(sc.nextInt(), sc.nextInt(), 0);
		Point J = new Point(sc.nextInt(), sc.nextInt(), 0);

		int first = bfs(B, J, true);
		int second = bfs(D, J, false);
		System.out.print((first < second) ? "bessie" : ((first > second) ? "daisy" : "tie"));
	}

	private static int bfs(Point start, Point end, boolean cow) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[1001][1001];
		q.add(start);
		visited[start.y][start.x] = true;

		while (!q.isEmpty()) {
			Point u = q.poll();
			if (u.y == end.y && u.x == end.x)
				return u.count;

			for (int i = 0; i < 4; i++) {
				int y = u.y + dy[i];
				int x = u.x + dx[i];
				if (y <= 0 || y > 1000 || x <= 0 || x > 1000 || visited[y][x])
					continue;

				q.add(new Point(y, x, u.count + 1));
				visited[y][x] = true;
			}

			if (cow) {
				for (int i = 0; i < 4; i++) {
					int y = u.y + ny[i];
					int x = u.x + nx[i];
					if (y <= 0 || y > 1000 || x <= 0 || x > 1000 || visited[y][x])
						continue;

					q.add(new Point(y, x, u.count + 1));
					visited[y][x] = true;
				}
			}
		}

		return -1;
	}

	private static class Point {
		public int y, x, count;

		public Point(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
}