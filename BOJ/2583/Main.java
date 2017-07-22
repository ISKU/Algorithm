/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2583
 */

import java.util.*;

public class Main {

	private static int[][] graph;
	private static boolean[][] visited;
	private static int Y, X;
	private static int count;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Y = input.nextInt();
		X = input.nextInt();
		graph = new int[Y][X];
		visited = new boolean[Y][X];

		int K = input.nextInt();
		while (K-- > 0) {
			Point first = new Point(input.nextInt(), input.nextInt());
			Point second = new Point(input.nextInt(), input.nextInt());
			for (int y = first.y; y < second.y; y++)
				for (int x = first.x; x < second.x; x++)
					graph[y][x] = 1;
		}

		ArrayList<Integer> area = new ArrayList<Integer>();
		int cluster = 0;
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (graph[y][x] == 0 && !visited[y][x]) {
					count = 0;
					dfs(y, x, ++cluster);
					area.add(count);
				}

		Collections.sort(area);
		System.out.println(cluster);
		for (int width : area)
			System.out.printf("%d ", width);
	}

	private static void dfs(int y, int x, int cluster) {
		visited[y][x] = true;
		graph[y][x] = cluster;
		count++;

		if (y - 1 >= 0 && !visited[y - 1][x] && graph[y - 1][x] == 0)
			dfs(y - 1, x, cluster);
		if (y + 1 < Y && !visited[y + 1][x] && graph[y + 1][x] == 0)
			dfs(y + 1, x, cluster);
		if (x - 1 >= 0 && !visited[y][x - 1] && graph[y][x - 1] == 0)
			dfs(y, x - 1, cluster);
		if (x + 1 < X && !visited[y][x + 1] && graph[y][x + 1] == 0)
			dfs(y, x + 1, cluster);
	}

	private static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}