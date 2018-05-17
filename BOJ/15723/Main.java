/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15723
 */

import java.util.*;

public class Main {

	private static int[] graph;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		graph = new int[26];
		Arrays.fill(graph, -1);

		int N = sc.nextInt();
		while (N-- > 0) {
			int u = sc.next().charAt(0) - 'a';
			sc.next();
			int v = sc.next().charAt(0) - 'a';
			graph[u] = v;
		}

		int M = sc.nextInt();
		while (M-- > 0) {
			int u = sc.next().charAt(0) - 'a';
			sc.next();
			int v = sc.next().charAt(0) - 'a';

			System.out.println((dfs(u, v) == v) ? "T" : "F");
		}
	}

	private static int dfs(int u, int v) {
		if (graph[u] == -1)
			return -1;
		if (graph[u] == v)
			return v;
		return dfs(graph[u], v);
	}
}