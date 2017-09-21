/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.09.17
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14716
 */

import java.util.*;

public class Main {

	private static int Y;
	private static int X;
	private static boolean[][] graph;
	private static boolean[][] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		Y = input.nextInt();
		X = input.nextInt();
		graph = new boolean[Y][X];
		visited = new boolean[Y][X];

		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				graph[y][x] = (input.nextInt() == 1) ? true : false;

		int answer = 0;
		for (int y = 0; y < Y; y++)
			for (int x = 0; x < X; x++)
				if (graph[y][x] && !visited[y][x]) {
					dfs(y, x);
					answer++;
				}

		System.out.println(answer);
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;

		if (y - 1 >= 0 && !visited[y - 1][x] && graph[y - 1][x])
			dfs(y - 1, x);
		if (y + 1 < Y && !visited[y + 1][x] && graph[y + 1][x])
			dfs(y + 1, x);
		if (x - 1 >= 0 && !visited[y][x - 1] && graph[y][x - 1])
			dfs(y, x - 1);
		if (x + 1 < X && !visited[y][x + 1] && graph[y][x + 1])
			dfs(y, x + 1);
		if (y - 1 >= 0 && x - 1 >= 0 && !visited[y - 1][x - 1] && graph[y - 1][x - 1])
			dfs(y - 1, x - 1);
		if (y - 1 >= 0 && x + 1 < X && !visited[y - 1][x + 1] && graph[y - 1][x + 1])
			dfs(y - 1, x + 1);
		if (y + 1 < Y && x - 1 >= 0 && !visited[y + 1][x - 1] && graph[y + 1][x - 1])
			dfs(y + 1, x - 1);
		if (y + 1 < Y && x + 1 < X && !visited[y + 1][x + 1] && graph[y + 1][x + 1])
			dfs(y + 1, x + 1);
	}
}