/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16174
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][N];
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				map[y][x] = sc.nextInt();

		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Point(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int y = p.y + map[p.y][p.x];
			int x = p.x + map[p.y][p.x];

			if (p.y == N - 1 && p.x == N - 1) {
				System.out.print("HaruHaru");
				System.exit(0);
			}

			if (y < N && !visited[y][p.x]) {
				q.add(new Point(y, p.x));
				visited[y][p.x] = true;
			}
			if (x < N && !visited[p.y][x]) {
				q.add(new Point(p.y, x));
				visited[p.y][x] = true;
			}
		}

		System.out.print("Hing");
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}