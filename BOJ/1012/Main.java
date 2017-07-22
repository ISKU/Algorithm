/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1012
 */

import java.util.*;

public class Main {

	private static boolean[][] graph;
	private static boolean[][] visited;
	private static int Y, X;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			X = input.nextInt();
			Y = input.nextInt();
			graph = new boolean[X][Y];
			visited = new boolean[X][Y];

			int K = input.nextInt();
			while (K-- > 0)
				graph[input.nextInt()][input.nextInt()] = true;

			int cluster = 0;
			for (int x = 0; x < X; x++)
				for (int y = 0; y < Y; y++)
					if (graph[x][y] && !visited[x][y])
						dfs(x, y, ++cluster);

			System.out.println(cluster);
		}
	}

	private static void dfs(int x, int y, int cluster) {
		visited[x][y] = true;

		if (x - 1 >= 0 && !visited[x - 1][y] && graph[x - 1][y])
			dfs(x - 1, y, cluster);
		if (x + 1 < X && !visited[x + 1][y] && graph[x + 1][y])
			dfs(x + 1, y, cluster);
		if (y - 1 >= 0 && !visited[x][y - 1] && graph[x][y - 1])
			dfs(x, y - 1, cluster);
		if (y + 1 < Y && !visited[x][y + 1] && graph[x][y + 1])
			dfs(x, y + 1, cluster);
	}
}