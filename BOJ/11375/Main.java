/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.25
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11375
 */

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;

public class Main {

	private static Vector<Vector<Integer>> graph;
	private static int[] source;
	private static int[] sink;
	private static boolean[] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		source = new int[N + 1];
		sink = new int[M + 1];
		visited = new boolean[N + 1];
		graph = new Vector<Vector<Integer>>();
		for (int i = 0; i < N + 1; i++)
			graph.add(new Vector<Integer>());

		for (int u = 1; u <= N; u++)
			for (int i = input.nextInt(); i > 0; i--)
				graph.get(u).add(input.nextInt());

		int match = 0;
		Arrays.fill(source, -1);
		Arrays.fill(sink, -1);
		for (int i = 1; i <= N; i++) {
			if (source[i] == -1) {
				Arrays.fill(visited, false);
				if (dfs(i))
					match++;
			}
		}

		System.out.println(match);
	}

	private static boolean dfs(int cur) {
		visited[cur] = true;

		for (int dest : graph.get(cur)) {
			if (sink[dest] == -1 || !visited[sink[dest]] && dfs(sink[dest])) {
				source[cur] = dest;
				sink[dest] = cur;
				return true;
			}
		}

		return false;
	}
}