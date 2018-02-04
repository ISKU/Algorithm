/*
 * Author: Minho Kim (ISKU)
 * Date: February 05, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1068
 */

import java.util.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static int R, count;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();

		graph = new ArrayList[V];
		for (int i = 0; i < V; i++)
			graph[i] = new ArrayList<Integer>();

		int root = 0;
		for (int i = 0; i < V; i++) {
			int parent = sc.nextInt();
			if (parent == -1)
				root = i;
			else
				graph[parent].add(i);
		}

		R = sc.nextInt();
		if (R != root)
			dfs(root);

		System.out.print(count);
	}

	private static void dfs(int vertex) {
		for (int to : graph[vertex]) {
			if (to == R) {
				if (graph[vertex].size() == 1)
					count++;
			} else {
				if (graph[to].size() == 0)
					count++;
				dfs(to);
			}
		}
	}
}