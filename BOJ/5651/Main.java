/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.02
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5651
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

	private static ArrayList<ArrayList<Integer>> network;
	private static Queue<Integer> queue;
	private static int[][] capacity;
	private static int[][] flow;
	private static int[][] table;
	private static int[] prev;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int N = input.nextInt();
			int M = input.nextInt();

			queue = new LinkedList<Integer>();
			prev = new int[N + 1];
			capacity = new int[N + 1][N + 1];
			flow = new int[N + 1][N + 1];
			table = new int[M + 1][2];
			network = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N + 1; i++)
				network.add(new ArrayList<Integer>());

			for (int i = 1; i <= M; i++) {
				int u = input.nextInt();
				int v = input.nextInt();
				int w = input.nextInt();
				network.get(u).add(v);
				network.get(v).add(u);
				capacity[u][v] += w;
				table[i][0] = u;
				table[i][1] = v;
			}

			int source = 1, sink = N;
			while (true) {
				Arrays.fill(prev, -1);

				queue.add(source);
				while (!queue.isEmpty()) {
					int cur = queue.poll();

					for (int dest : network.get(cur)) {
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
			}

			int total = 0;
			for (int i = 1; i <= M; i++) {
				source = table[i][0];
				sink = table[i][1];

				if (flow[source][sink] != capacity[source][sink])
					continue;

				Arrays.fill(prev, -1);
				queue.add(source);
				while (!queue.isEmpty()) {
					int cur = queue.poll();

					for (int dest : network.get(cur)) {
						if (capacity[cur][dest] - flow[cur][dest] > 0 && prev[dest] == -1) {
							queue.add(dest);
							prev[dest] = cur;

							if (dest == sink)
								break;
						}
					}
				}

				if (prev[sink] == -1)
					total++;
			}

			System.out.println(total);
		}
	}
}