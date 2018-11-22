/*
 * Author: Minho Kim (ISKU)
 * Date: November 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16236
 */

import java.util.*;

public class Main {

	private static final int[] dy = new int[] { -1, 0, 0, 1 };
	private static final int[] dx = new int[] { 0, -1, 1, 0 };

	private static int[][] map;
	private static Fish shark;
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
				if (map[y][x] == 9) {
					shark = new Fish(y, x, 2, 0, 0);
					map[y][x] = 0;
				}
			}
		}

		while (bfs())
			;
		System.out.print(shark.move);
	}

	private static boolean bfs() {
		Queue<Fish> q = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				if (o1.move == o2.move) {
					if (o1.y == o2.y)
						return Integer.compare(o1.x, o2.x);
					return Integer.compare(o1.y, o2.y);
				}
				return Integer.compare(o1.move, o2.move);
			}
		});
		boolean[][] visited = new boolean[N][N];
		q.add(shark);
		visited[shark.y][shark.x] = true;

		while (!q.isEmpty()) {
			Fish u = q.poll();
			if (map[u.y][u.x] > 0 && u.size > map[u.y][u.x]) {
				map[u.y][u.x] = 0;
				u.count++;

				if (u.size == u.count) {
					u.count = 0;
					u.size++;
				}

				shark = u;
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int y = u.y + dy[i];
				int x = u.x + dx[i];
				if (y < 0 || y >= N || x < 0 || x >= N || visited[y][x])
					continue;
				if (u.size < map[y][x])
					continue;

				q.add(new Fish(y, x, u.size, u.count, u.move + 1));
				visited[y][x] = true;
			}
		}

		return false;
	}

	private static class Fish {
		public int y, x;
		public int size, count, move;

		public Fish(int y, int x, int size, int count, int move) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.count = count;
			this.move = move;
		}
	}
}