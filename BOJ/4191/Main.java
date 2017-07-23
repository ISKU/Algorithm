/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4191
 */

import java.util.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static boolean[] visited;
	private static int count;

	public static void main(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int n = input.nextInt() + 1;
			int m = input.nextInt();
			int k = input.nextInt();

			count = 0;
			graph = new ArrayList<ArrayList<Integer>>();
			visited = new boolean[n];
			for (int i = 0; i < n; i++)
				graph.add(new ArrayList<Integer>());

			while (m-- > 0)
				graph.get(input.nextInt()).add(input.nextInt());

			while (k-- > 0) {
				int vertex = input.nextInt();
				if (!visited[vertex])
					dfs(vertex);
			}

			System.out.println(count);
		}
	}

	private static void dfs(int vertex) {
		visited[vertex] = true;
		count++;

		for (int sink : graph.get(vertex))
			if (!visited[sink])
				dfs(sink);
	}
}