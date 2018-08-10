/*
 * Author: Minho Kim (ISKU)
 * Date: August 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5214
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[N + M + 1];
		for (int i = 1; i < graph.length; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				int u = Integer.parseInt(st.nextToken());
				int v = N + i;
				graph[u].add(v);
				graph[v].add(u);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[N + M + 1];
		q.add(1);
		visited[1] = 1;
		while (!q.isEmpty()) {
			int u = q.poll();
			if (u == N) {
				System.out.print(visited[u]);
				System.exit(0);
			}

			for (int v : graph[u]) {
				if (visited[v] == 0) {
					q.add(v);
					visited[v] = (v > N) ? visited[u] : visited[u] + 1;
				}
			}
		}

		System.out.print(-1);
	}
}