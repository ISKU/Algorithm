/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.25
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2316
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
		int P = input.nextInt();

		capacity = new int[N * 2 + 1][N * 2 + 1];
		flow = new int[N * 2 + 1][N * 2 + 1];
		graph = new Vector<Vector<Integer>>();
		for (int i = 0; i < N * 2 + 1; i++)
			graph.add(new Vector<Integer>());

		for (int u = 1; u <= N; u++) {
			graph.get(u).add(u + N);
			capacity[u][u + N] = 1;
		}
		while (P-- > 0) {
			int u = input.nextInt();
			int v = input.nextInt();
			graph.get(u + N).add(v);
			graph.get(v + N).add(u);
			capacity[u + N][v] = 1;
			capacity[v + N][u] = 1;
		}

		int total = 0;
		int source = 1 + N, sink = 2;
		while (true) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] prev = new int[N * 2 + 1];
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