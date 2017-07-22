/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.22
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2468
 */

import java.util.*;

public class Main {

	private static int[][] originGraph;
	private static int[][] graph;
	private static boolean[][] visited;
	private static int N;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		originGraph = new int[N][N];
		graph = new int[N][N];

		SortedSet<Integer> heightSet = new TreeSet<Integer>();
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++) {
				originGraph[y][x] = input.nextInt();
				heightSet.add(originGraph[y][x]);
			}

		int answer = 1;
		for (int height : heightSet) {
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					graph[y][x] = originGraph[y][x] - height;

			visited = new boolean[N][N];
			int cluster = 0;
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					if (graph[y][x] > 0 && !visited[y][x])
						dfs(y, x, ++cluster);

			answer = Math.max(answer, cluster);
		}

		System.out.print(answer);
	}

	private static void dfs(int y, int x, int cluster) {
		visited[y][x] = true;

		if (y - 1 >= 0 && !visited[y - 1][x] && graph[y - 1][x] > 0)
			dfs(y - 1, x, cluster);
		if (y + 1 < N && !visited[y + 1][x] && graph[y + 1][x] > 0)
			dfs(y + 1, x, cluster);
		if (x - 1 >= 0 && !visited[y][x - 1] && graph[y][x - 1] > 0)
			dfs(y, x - 1, cluster);
		if (x + 1 < N && !visited[y][x + 1] && graph[y][x + 1] > 0)
			dfs(y, x + 1, cluster);
	}
}