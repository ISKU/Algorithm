/*
 * Author: Minho Kim (ISKU)
 * Date: December 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10217
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] graph;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			graph = new List[N + 1];
			for (int i = 1; i <= N; i++)
				graph[i] = new ArrayList<Edge>();
			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				graph[u].add(new Edge(v, w, t));
			}

			bw.write(dijkstra());
			bw.write('\n');
		}

		bw.close();
	}

	private static String dijkstra() {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		int[][] dist = new int[M + 1][N + 1];
		for (int i = 0; i <= M; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][1] = 0;
		}
		pq.add(new Edge(1, 0, 0));

		int answer = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (answer <= dist[u.weight][u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				int cost = u.weight + v.weight;
				if (cost > M)
					continue;

				int time = dist[u.weight][u.vertex] + v.time;
				if (answer <= time)
					continue;
				if (v.vertex == N) {
					answer = time;
					continue;
				}
				if (time < dist[cost][v.vertex]) {
					if (dist[cost][v.vertex] == Integer.MAX_VALUE)
						pq.add(new Edge(v.vertex, cost, time));
					dist[cost][v.vertex] = time;
				}
			}
		}

		if (answer == Integer.MAX_VALUE)
			return "Poor KCM";
		return String.valueOf(answer);
	}

	private static class Edge {
		public int vertex, weight, time;

		public Edge(int vertex, int weight, int time) {
			this.vertex = vertex;
			this.weight = weight;
			this.time = time;
		}
	}
}