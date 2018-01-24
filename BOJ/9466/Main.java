/*
 * Author: Minho Kim (ISKU)
 * Date: January 24, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9466
 */

import java.util.*;

public class Main {

	private static int[] graph;
	private static int[] visited;
	private static int count;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		while (testCase-- > 0) {
			int N = sc.nextInt();

			graph = new int[N + 1];
			for (int i = 1; i <= N; i++)
				graph[i] = sc.nextInt();

			count = 0;
			visited = new int[N + 1];
			for (int i = 1; i <= N; i++)
				dfs(i, 1);

			System.out.println(N - count);
		}
	}

	private static void dfs(int vertex, int step) {
		if (visited[vertex] == -1)
			return;

		if (visited[vertex] > 0) {
			count += step - visited[vertex];
			return;
		}

		visited[vertex] = step;
		dfs(graph[vertex], step + 1);
		visited[vertex] = -1;
	}
}