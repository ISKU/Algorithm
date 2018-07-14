/*
 * Author: Minho Kim (ISKU)
 * Date: July 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6086
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] network;
	private static int[][] capacity;
	private static int[][] flow;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		capacity = new int[52][52];
		flow = new int[52][52];
		network = new ArrayList[52];
		for (int i = 0; i < 52; i++)
			network[i] = new ArrayList<Integer>();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = ctoi(st.nextToken().charAt(0));
			int v = ctoi(st.nextToken().charAt(0));
			int w = Integer.parseInt(st.nextToken());
			network[u].add(v);
			network[v].add(u);
			capacity[u][v] += w;
			capacity[v][u] += w;
		}

		int total = 0;
		int source = ctoi('A');
		int sink = ctoi('Z');
		while (true) {
			Queue<Integer> q = new LinkedList<Integer>();
			int[] prev = new int[52];
			Arrays.fill(prev, -1);

			q.add(source);
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int next : network[cur]) {
					if (capacity[cur][next] - flow[cur][next] > 0 && prev[next] == -1) {
						q.add(next);
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