/*
 * Author: Minho Kim (ISKU)
 * Date: December 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11779
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] graph;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Edge>();
		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start, end);
	}

	private static void dijkstra(int start, int end) throws Exception {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		int[] prev = new int[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				int cost = u.weight + v.weight;

				if (cost < dist[v.vertex]) {
					dist[v.vertex] = cost;
					prev[v.vertex] = u.vertex;
					pq.add(new Edge(v.vertex, cost));
				}
			}
		}

		List<Integer> path = new ArrayList<>();
		for (int v = end; v != 0; v = prev[v])
			path.add(v);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(dist[end]));
		bw.write('\n');
		bw.write(String.valueOf(path.size()));
		bw.write('\n');
		for (int i = path.size() - 1; i >= 0; i--) {
			bw.write(String.valueOf(path.get(i)));
			bw.write(' ');
		}
		bw.close();
	}

	private static class Edge {
		public int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}