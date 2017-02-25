/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.25
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6086
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

		capacity = new int[52][52];
		flow = new int[52][52];
		graph = new Vector<Vector<Integer>>();
		for (int i = 0; i < 52; i++)
			graph.add(new Vector<Integer>());

		while (N-- > 0) {
			int u = ctoi(input.next().charAt(0));
			int v = ctoi(input.next().charAt(0));
			int w = input.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
			capacity[u][v] += w;
		}

		int total = 0;
		int source = ctoi('A'), sink = ctoi('Z');
		while (true) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] prev = new int[52];
			Arrays.fill(prev, -1);

			queue.add(source);
			while (!queue.isEmpty()) {
				int cur = queue.poll();

				for (int next : graph.get(cur)) {
					if (capacity[cur][next] - flow[cur][next] > 0 && prev[next] == -1) {
						queue.add(next);
						prev[next] = cur;

						if (next == sink)
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

	private static int ctoi(char letter) {
		if (letter <= 'Z')
			return letter - 'A';
		else
			return letter - 'a' + 26;
	}
}