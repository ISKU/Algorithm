/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11409
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
	private static int[][] cost;
	private static int[] prev;
	private static int[] dist;
	private static boolean[] contains;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		int source = 0, sink = N + M + 1;
		capacity = new int[N + M + 2][N + M + 2];
		flow = new int[N + M + 2][N + M + 2];
		cost = new int[N + M + 2][N + M + 2];
		prev = new int[N + M + 2];
		dist = new int[N + M + 2];
		contains = new boolean[N + M + 2];

		network = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + M + 2; i++)
			network.add(new ArrayList<Integer>());

		for (int u = 1; u <= N; u++) {
			for (int i = input.nextInt(); i > 0; i--) {
				int v = input.nextInt() + N;
				int c = input.nextInt();
				network.get(u).add(v);
				network.get(v).add(u);
				cost[u][v] = -c;
				cost[v][u] = c;
				capacity[u][v] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i <= N; i++) {
			network.get(source).add(i);
			network.get(i).add(source);
			capacity[source][i] = 1;
		}
		for (int i = N + 1; i <= N + M; i++) {
			network.get(i).add(sink);
			network.get(sink).add(i);
			capacity[i][sink] = 1;
		}

		int result = 0;
		int total = 0;
		while (true) {
			queue = new LinkedList<Integer>();
			Arrays.fill(prev, -1);
			Arrays.fill(dist, Integer.MAX_VALUE);
			contains = new boolean[N + M + 2];

			dist[source] = 0;
			contains[source] = true;
			queue.add(source);
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				contains[cur] = false;

				for (int dest : network.get(cur)) {
					if (capacity[cur][dest] - flow[cur][dest] > 0 && dist[dest] > dist[cur] + cost[cur][dest]) {
						dist[dest] = dist[cur] + cost[cur][dest];
						prev[dest] = cur;

						if (!contains[dest]) {
							queue.add(dest);
							contains[dest] = true;
						}
					}
				}
			}

			if (prev[sink] == -1)
				break;

			for (int i = sink; i != source; i = prev[i]) {
				result += cost[prev[i]][i];
				flow[prev[i]][i]++;
				flow[i][prev[i]]--;
			}

			total++;
		}

		System.out.println(total);
		System.out.println(-result);
	}
}