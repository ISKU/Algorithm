/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.25
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2188
 */

import java.util.Scanner;
import java.util.Vector;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

	private static Vector<Vector<Integer>> graph;
	private static int[][] capacity;
	private static int[][] flow;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		int source = 0, sink = N + M + 1;
		capacity = new int[N + M + 2][N + M + 2];
		flow = new int[N + M + 2][N + M + 2];
		graph = new Vector<Vector<Integer>>();
		for (int i = 0; i < N + M + 2; i++)
			graph.add(new Vector<Integer>());

		for (int u = 1; u <= N; u++) {
			for (int i = input.nextInt(); i > 0; i--) {
				int v = input.nextInt() + N;
				graph.get(u).add(v);
				graph.get(v).add(u);
				capacity[u][v] = 1;
			}
		}
		for (int i = 1; i <= N; i++) {
			graph.get(source).add(i);
			graph.get(i).add(source);
			capacity[source][i] = 1;
		}
		for (int i = 1; i <= M; i++) {
			graph.get(sink).add(N + i);
			graph.get(N + i).add(sink);
			capacity[N + i][sink] = 1;
		}

		int total = 0;
		while (true) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] prev = new int[N + M + 2];
			Arrays.fill(prev, -1);

			queue.add(source);
			while (!queue.isEmpty()) {
				int cur = queue.poll();

				for (int dest : graph.get(cur)) {
					if (capacity[cur][dest] - flow[cur][dest] > 0 && prev[dest] == -1) {
						queue.add(dest);
						prev[dest] = cur;

						if (dest == sink)
							break;
					}
				}
			}

			if (prev[sink] == -1)
				break;

			int curflow = Integer.MAX_VALUE;
			for (int i = sink; i != source; i = prev[i])
				curflow = Math.min(curflow, capacity[prev[i]][i] - flow[prev[i]][i]);

			for (int i = sink; i != source; i = prev[i]) {
				flow[prev[i]][i] += curflow;
				flow[i][prev[i]] -= curflow;
			}

			total += curflow;
		}

		System.out.print(total);
	}
}