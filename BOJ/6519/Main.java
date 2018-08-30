/*
 * Author: Minho Kim (ISKU)
 * Date: August 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6519
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };
	private static final String[] dpath = new String[] { "N", "E", "S", "W" };

	private static boolean[][] map;
	private static boolean[][] visited;
	private static Queue<Point> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int cx = sc.nextInt();
			int cy = sc.nextInt();
			if (cx == 0 && cy == 0)
				break;

			Point start = new Point(cy * 2 - 1, cx * 2 - 1, "");
			Point end = new Point(sc.nextInt() * 2 - 1, sc.nextInt() * 2 - 1);

			map = new boolean[13][13];
			for (int i = 0; i < 3; i++) {
				int sx = sc.nextInt() * 2;
				int sy = sc.nextInt() * 2;
				int ex = sc.nextInt() * 2;
				int ey = sc.nextInt() * 2;

				if (sy == ey) {
					for (int x = sx; x <= ex; x++)
						map[sy][x] = true;
				} else {
					for (int y = sy; y <= ey; y++)
						map[y][sx] = true;
				}
			}

			q = new LinkedList<Point>();
			q.add(start);
			visited = new boolean[13][13];
			visited[start.y][start.x] = true;
			while (!q.isEmpty()) {
				Point p = q.poll();
				if (p.y == end.y && p.x == end.x) {
					System.out.println(p.path);
					break;
				}

				for (int i = 0; i < 4; i++) {
					int y = p.y + dy[i];
					int x = p.x + dx[i];
					if (y >= 13 || y < 0 || x >= 13 || x < 0 || map[y][x] || visited[y][x])
						continue;

					if (y % 2 == 1 && x % 2 == 1) {
						visited[y][x] = true;
						q.add(new Point(y, x, p.path + dpath[i]));
					} else {
						visited[y][x] = true;
						q.add(new Point(y, x, p.path));
					}
				}
			}
		}
	}

	private static class Point {
		public int x, y;
		public String path;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int y, int x, String path) {
			this.y = y;
			this.x = x;
			this.path = path;
		}
	}
}