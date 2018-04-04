/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1987
 */

import java.util.*;

public class Main {

	private static char[][] graph;
	private static boolean[] visited;
	private static int R, C;
	private static int count = 0;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		R = input.nextInt();
		C = input.nextInt();
		graph = new char[R][C];

		for (int y = 0; y < R; y++)
			graph[y] = input.next().toCharArray();

		visited = new boolean[92];
		dfs(0, 0, 1);
		System.out.print(count);
	}

	private static void dfs(int y, int x, int step) {
		visited[graph[y][x]] = true;
		count = Math.max(count, step);
		if (count == 26)
			return;

		if (y - 1 >= 0 && !visited[graph[y - 1][x]]) {
			dfs(y - 1, x, step + 1);
			visited[graph[y - 1][x]] = false;
		}
		if (y + 1 < R && !visited[graph[y + 1][x]]) {
			dfs(y + 1, x, step + 1);
			visited[graph[y + 1][x]] = false;
		}
		if (x - 1 >= 0 && !visited[graph[y][x - 1]]) {
			dfs(y, x - 1, step + 1);
			visited[graph[y][x - 1]] = false;
		}
		if (x + 1 < C && !visited[graph[y][x + 1]]) {
			dfs(y, x + 1, step + 1);
			visited[graph[y][x + 1]] = false;
		}
	}
}