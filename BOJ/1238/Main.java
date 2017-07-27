/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.27
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1238
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Edge>> graph;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		N = Integer.parseInt(parser.nextToken()) + 1;
		int M = Integer.parseInt(parser.nextToken());
		int X = Integer.parseInt(parser.nextToken());

		graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < N; i++)
			graph.add(new ArrayList<Edge>());
		
		while (M-- > 0) {
			parser = new StringTokenizer(input.readLine());
			graph.get(Integer.parseInt(parser.nextToken())).add(new Edge(Integer.parseInt(parser.nextToken()), Integer.parseInt(parser.nextToken())));
		}
		
		int answer = 0;
		for (int i = 1; i < N; i++)
			answer = Math.max(answer, dijkstra(i, X) + dijkstra(X, i));
		System.out.print(answer);
	}

	private static int dijkstra(final int start, final int end) {
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge A, Edge B) {
				return A.weight - B.weight;
			}
		}) {{add(new Edge(start, 0));}};

		int[] dist = new int[N];
		Arrays.fill(dist, -1);
		dist[start] = 0;

		while (!pQueue.isEmpty()) {
			Edge source = pQueue.poll();

			for (Edge sink : graph.get(source.vertex)) {
				int next = dist[source.vertex] + sink.weight;
				if (dist[sink.vertex] == -1 || dist[sink.vertex] > next) {
					dist[sink.vertex] = next;
					pQueue.add(new Edge(sink.vertex, next));
				}
			}
		}

		return dist[end];
	}

	private static class Edge {
		public int vertex;
		public int weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}