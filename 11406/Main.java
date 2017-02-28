/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11406
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

		for (int i = M + 1; i <= M + N; i++) {
			capacity[i][sink] = input.nextInt();
			network.get(i).add(sink);
			network.get(sink).add(i);
		}
		for (int i = 1; i <= M; i++) {
			capacity[source][i] = input.nextInt();
			network.get(i).add(source);
			network.get(source).add(i);
		}
		for (int i = 1; i <= M; i++) {
			for (int j = M + 1; j <= M + N; j++) {
				capacity[i][j] = input.nextInt();
				network.get(i).add(j);
				network.get(j).add(i);
			}
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

			int curflow = Integer.MAX_VALUE;
			for (int i = sink; i != source; i = prev[i])
				curflow = Math.min(curflow, capacity[prev[i]][i] - flow[prev[i]][i]);

			for (int i = sink; i != source; i = prev[i]) {
				result += curflow * cost[prev[i]][i];
				flow[prev[i]][i] += curflow;
				flow[i][prev[i]] -= curflow;
			}

			total += curflow;
		}

		System.out.println(total);
	}
}