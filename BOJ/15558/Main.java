/*
 * Author: Minho Kim (ISKU)
 * Date: February 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15558
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		boolean[][] graph = new boolean[2][N];
		for (int i = 0; i < 2; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++)
				graph[i][j] = (line.charAt(j) == '1') ? true : false;
		}

		boolean[][] visited = new boolean[2][N];
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 1));
		visited[0][0] = true;

		int answer = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			int y = p.y;
			int x = p.x;
			int S = p.S;

			if (x + 1 >= N || x + K >= N) {
				answer = 1;
				break;
			}

			if (x + 1 < N && graph[y][x + 1] && !visited[y][x + 1]) {
				visited[y][x + 1] = true;
				q.add(new Point(y, x + 1, S + 1));
			}
			if (x - 1 >= S && graph[y][x - 1] && !visited[y][x - 1]) {
				visited[y][x - 1] = true;
				q.add(new Point(y, x - 1, S + 1));
			}
			if (y == 0 && x + K < N && graph[1][x + K] && !visited[1][x + K]) {
				visited[1][x + K] = true;
				q.add(new Point(1, x + K, S + 1));
			}
			if (y == 1 && x + K < N && graph[0][x + K] && !visited[0][x + K]) {
				visited[0][x + K] = true;
				q.add(new Point(0, x + K, S + 1));
			}
		}

		System.out.print(answer);
	}

	private static class Point {
		public int y, x, S;

		public Point(int y, int x, int S) {
			this.y = y;
			this.x = x;
			this.S = S;
		}
	}
}