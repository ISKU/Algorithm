/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1956
 */

import java.util.*;

public class Main {

	private static int INFINITY = 987654321;
	private static int[][] graph;
	private static int V;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		V = input.nextInt() + 1;
		int E = input.nextInt();

		graph = new int[V][V];
		for (int i = 1; i < V; i++)
			Arrays.fill(graph[i], INFINITY);

		while (E-- > 0)
			graph[input.nextInt()][input.nextInt()] = input.nextInt();

		for (int k = 1; k < V; k++)
			for (int y = 1; y < V; y++)
				for (int x = 1; x < V; x++)
					if (graph[y][x] > graph[y][k] + graph[k][x])
						graph[y][x] = graph[y][k] + graph[k][x];

		int answer = INFINITY;
		for (int i = 1; i < V; i++)
			answer = Math.min(answer, graph[i][i]);
		System.out.print((answer == INFINITY) ? -1 : answer);
	}
}