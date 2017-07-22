/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1987
 */

import java.util.*;

public class Main {

	private static String[][] graph;
	private static int R, C;
	private static int count = 0;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		R = input.nextInt();
		C = input.nextInt();
		graph = new String[R][C];

		for (int y = 0; y < R; y++)
			graph[y] = input.next().split("");

		dfs(0, 0, new HashSet<String>(26));
		System.out.print(count);
	}

	private static void dfs(int y, int x, HashSet<String> previous) {
		HashSet<String> visited = (HashSet<String>) previous.clone();
		visited.add(graph[y][x]);
		count = Math.max(count, visited.size());
		if (count == 26)
			return;

		if (y - 1 >= 0 && !visited.contains(graph[y - 1][x]))
			dfs(y - 1, x, visited);
		if (y + 1 < R && !visited.contains(graph[y + 1][x]))
			dfs(y + 1, x, visited);
		if (x - 1 >= 0 && !visited.contains(graph[y][x - 1]))
			dfs(y, x - 1, visited);
		if (x + 1 < C && !visited.contains(graph[y][x + 1]))
			dfs(y, x + 1, visited);
	}
}