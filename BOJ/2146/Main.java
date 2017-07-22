/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2146
 */

import java.util.*;

public class Main {

	private static int[][] graph;
	private static boolean[][] visited;
	private static int N;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		graph = new int[N][N];
		visited = new boolean[N][N];

		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				graph[y][x] = input.nextInt();

		int cluster = 1;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (!visited[y][x] && graph[y][x] == 1)
					dfs(y, x, cluster++);

		int answer = Integer.MAX_VALUE;
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				if (graph[y][x] >= 1)
					answer = Math.min(answer, bfs(new Point(y, x, graph[y][x], 0)));

		System.out.println((cluster <= 2) ? 0 : answer);
	}

	private static int bfs(Point start) {
		Queue<Point> queue = new LinkedList<Point>();
		visited = new boolean[N][N];
		int y = start.y;
		int x = start.x;
		int cluster = start.cluster;
		int count = 0;
		boolean check = false;

		queue.add(start);
		visited[y][x] = true;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			y = point.y;
			x = point.x;
			count = point.count;

			if (point.cluster != 0 && cluster != point.cluster) {
				count = point.count;
				check = true;
				break;
			}

			if (y - 1 >= 0 && graph[y - 1][x] != cluster && !visited[y - 1][x]) {
				queue.add(new Point(y - 1, x, graph[y - 1][x], count + 1));
				visited[y - 1][x] = true;
			}
			if (y + 1 < graph.length && graph[y + 1][x] != cluster && !visited[y + 1][x]) {
				queue.add(new Point(y + 1, x, graph[y + 1][x], count + 1));
				visited[y + 1][x] = true;
			}
			if (x - 1 >= 0 && graph[y][x - 1] != cluster && !visited[y][x - 1]) {
				queue.add(new Point(y, x - 1, graph[y][x - 1], count + 1));
				visited[y][x - 1] = true;
			}
			if (x + 1 < graph.length && graph[y][x + 1] != cluster && !visited[y][x + 1]) {
				queue.add(new Point(y, x + 1, graph[y][x + 1], count + 1));
				visited[y][x + 1] = true;
			}
		}

		return (check) ? count - 1 : Integer.MAX_VALUE;
	}

	private static void dfs(int y, int x, int cluster) {
		visited[y][x] = true;
		graph[y][x] = cluster;

		if (y - 1 >= 0 && !visited[y - 1][x] && graph[y - 1][x] == 1)
			dfs(y - 1, x, cluster);
		if (y + 1 < graph.length && !visited[y + 1][x] && graph[y + 1][x] == 1)
			dfs(y + 1, x, cluster);
		if (x - 1 >= 0 && !visited[y][x - 1] && graph[y][x - 1] == 1)
			dfs(y, x - 1, cluster);
		if (x + 1 < graph.length && !visited[y][x + 1] && graph[y][x + 1] == 1)
			dfs(y, x + 1, cluster);
	}

	private static class Point {
		public int y;
		public int x;
		public int cluster;
		public int count;

		public Point(int y, int x, int cluster, int count) {
			this.y = y;
			this.x = x;
			this.cluster = cluster;
			this.count = count;
		}
	}
}