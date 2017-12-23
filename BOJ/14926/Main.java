/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14926
 */

import java.util.*;

public class Main {

	public static boolean[][] visited;
	public static int[] count;
	public static int N;

	public static void main(String... args) {
		N = new Scanner(System.in).nextInt();
		visited = new boolean[N][N];
		count = new int[N];
		for (int i = 0; i < N; i++)
			visited[i][i] = true;

		dfs(0);
		System.out.print("a1");
	}

	private static void dfs(int vertex) {
		System.out.printf("a%d ", vertex + 1);

		for (int dest = 0; dest < N; dest++) {
			if (!visited[vertex][dest] && count[dest] + 1 < N - 1) {
				visited[vertex][dest] = true;
				visited[dest][vertex] = true;
				count[vertex]++;
				count[dest]++;
				dfs(dest);
			}
		}
	}
}