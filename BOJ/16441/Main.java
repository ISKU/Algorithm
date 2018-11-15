/*
 * Author: Minho Kim (ISKU)
 * Date: November 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16441
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 1, 0 };
	private static final int[] dx = new int[] { 0, 1, 0, -1 };

	private static char[][] map;
	private static boolean[][] visited;
	private static ArrayList<Point> wolfs;
	private static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		wolfs = new ArrayList<Point>();
		for (int y = 0; y < N; y++) {
			String line = sc.next();
			for (int x = 0; x < M; x++) {
				map[y][x] = line.charAt(x);
				if (map[y][x] == 'W')
					wolfs.add(new Point(y, x));
			}
		}

		visited = new boolean[N][M];
		for (int i = 0; i < wolfs.size(); i++)
			bfs(wolfs.get(i));

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == '.' && !visited[y][x])
					System.out.print('P');
				else
					System.out.print(map[y][x]);
			}
			System.out.println();
		}
	}

	private static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.y][start.x] = true;

		while (!q.isEmpty()) {
			Point wolf = q.poll();

			for (int i = 0; i < 4; i++) {
				int y = wolf.y + dy[i];
				int x = wolf.x + dx[i];
				if (visited[y][x] || map[y][x] == '#')
					continue;

				if (map[y][x] == '+') {
					Point dest = dfs(y, x, i);
					if (visited[dest.y][dest.x])
						continue;

					q.add(dest);
					visited[dest.y][dest.x] = true;
					continue;
				}

				q.add(new Point(y, x));
				visited[y][x] = true;
			}
		}
	}

	private static Point dfs(int y, int x, int dir) {
		if (map[y][x] == '.')
			return new Point(y, x);

		if (dir == 0) {
			if (map[y - 1][x] == '#')
				return new Point(y, x);
			return dfs(y - 1, x, dir);
		} else if (dir == 1) {
			if (map[y][x + 1] == '#')
				return new Point(y, x);
			return dfs(y, x + 1, dir);
		} else if (dir == 2) {
			if (map[y + 1][x] == '#')
				return new Point(y, x);
			return dfs(y + 1, x, dir);
		} else {
			if (map[y][x - 1] == '#')
				return new Point(y, x);
			return dfs(y, x - 1, dir);
		}
	}

	private static class Point {
		public int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}