/*
 * Author: Minho Kim (ISKU)
 * Date: September 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16054
 */

import java.util.*;

public class Main {

	private static HashMap<String, Integer> vertices;
	private static ArrayList<ArrayList<Integer>> graph;
	private static ArrayList<ArrayList<Integer>> reverse;
	private static boolean[] visited;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		vertices = new HashMap<String, Integer>();
		graph = new ArrayList<ArrayList<Integer>>();
		reverse = new ArrayList<ArrayList<Integer>>();
		int vertex = 0;
		while (N-- > 0) {
			String u = sc.next();
			sc.next();
			sc.next();
			sc.next();
			String v = sc.next();

			if (!vertices.containsKey(u)) {
				graph.add(new ArrayList<Integer>());
				reverse.add(new ArrayList<Integer>());
				vertices.put(u, vertex++);
			}
			if (!vertices.containsKey(v)) {
				graph.add(new ArrayList<Integer>());
				reverse.add(new ArrayList<Integer>());
				vertices.put(v, vertex++);
			}
			graph.get(vertices.get(u)).add(vertices.get(v));
			reverse.get(vertices.get(v)).add(vertices.get(u));
		}

		while (M-- > 0) {
			String u = sc.next();
			sc.next();
			sc.next();
			sc.next();
			String v = sc.next();

			if (!vertices.containsKey(u) || !vertices.containsKey(v)) {
				System.out.println("Pants on Fire");
				continue;
			}

			visited = new boolean[vertex];
			dfs(vertices.get(u), false);
			if (visited[vertices.get(v)]) {
				System.out.println("Fact");
				continue;
			}

			visited = new boolean[vertex];
			dfs(vertices.get(u), true);
			if (visited[vertices.get(v)]) {
				System.out.println("Alternative Fact");
				continue;
			}

			System.out.println("Pants on Fire");
		}
	}

	private static void dfs(int u, boolean r) {
		visited[u] = true;

		for (int v : (r) ? reverse.get(u) : graph.get(u))
			if (!visited[v])
				dfs(v, r);
	}
}