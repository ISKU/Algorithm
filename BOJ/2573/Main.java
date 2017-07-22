/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2573
 */

import java.util.*;

public class Main {

	private static int[][] originGraph;
	private static int[][] graph;
	private static boolean[][] visited;
	private static int N, M;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		originGraph = new int[N][M];
		graph = new int[N][M];

		for (int y = 0; y < N; y++)
			for (int x = 0; x < M; x++) {
				originGraph[y][x] = input.nextInt();
				graph[y][x] = originGraph[y][x];
			}

		boolean check = false;
		int answer = 1;
		while (!isZero()) {
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if (originGraph[y][x] > 0) {
						if (y - 1 >= 0 && originGraph[y - 1][x] <= 0)
							graph[y][x]--;
						if (y + 1 < N && originGraph[y + 1][x] <= 0)
							graph[y][x]--;
						if (x - 1 >= 0 && originGraph[y][x - 1] <= 0)
							graph[y][x]--;
						if (x + 1 < M && originGraph[y][x + 1] <= 0)
							graph[y][x]--;
					}

			visited = new boolean[N][M];
			int cluster = 0;
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if (graph[y][x] > 0 && !visited[y][x])
						dfs(y, x, ++cluster);

			if (cluster >= 2) {
				check = true;
				break;
			}

			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					originGraph[y][x] = graph[y][x];
			answer++;
		}

		System.out.print(check ? answer : 0);
	}

	private static boolean isZero() {
		for (int y = 0; y < N; y++)
			for (int x = 0; x < M; x++)
				if (graph[y][x] > 0)
					return false;

		return true;
	}

	private static void dfs(int y, int x, int cluster) {
		visited[y][x] = true;

		if (y - 1 >= 0 && !visited[y - 1][x] && graph[y - 1][x] > 0)
			dfs(y - 1, x, cluster);
		if (y + 1 < N && !visited[y + 1][x] && graph[y + 1][x] > 0)
			dfs(y + 1, x, cluster);
		if (x - 1 >= 0 && !visited[y][x - 1] && graph[y][x - 1] > 0)
			dfs(y, x - 1, cluster);
		if (x + 1 < M && !visited[y][x + 1] && graph[y][x + 1] > 0)
			dfs(y, x + 1, cluster);
	}
}