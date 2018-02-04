/*
 * Author: Minho Kim (ISKU)
 * Date: February 04, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2252
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int V, E;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++)
			graph[i] = new ArrayList<Integer>();

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			graph[second].add(first);
		}

		visited = new boolean[V + 1];
		for (int i = 1; i <= V; i++)
			if (!visited[i])
				dfs(i);
	}

	private static void dfs(int vertex) {
		visited[vertex] = true;

		for (int to : graph[vertex])
			if (!visited[to])
				dfs(to);

		System.out.printf("%d ", vertex);
	}
}