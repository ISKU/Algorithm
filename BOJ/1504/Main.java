/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.27
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1504
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Edge>> graph;
	private static int N, E;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		N = Integer.parseInt(parser.nextToken()) + 1;
		E = Integer.parseInt(parser.nextToken());

		graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < N; i++)
			graph.add(new ArrayList<Edge>());

		while (E-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());
			int weight = Integer.parseInt(parser.nextToken());
			graph.get(first).add(new Edge(second, weight));
			graph.get(second).add(new Edge(first, weight));
		}

		parser = new StringTokenizer(input.readLine());
		int A = Integer.parseInt(parser.nextToken());
		int B = Integer.parseInt(parser.nextToken());

		int startToA = dijkstra(1, A);
		int startToB = dijkstra(1, B);
		int AtoB = dijkstra(A, B);
		int BtoA = dijkstra(B, A);
		int AtoEnd = dijkstra(A, N - 1);
		int BtoEnd = dijkstra(B, N - 1);

		if (startToA == -1 || AtoB == -1 || BtoEnd == -1) {
			if (startToB == -1 || BtoA == -1 || AtoEnd == -1)
				System.out.print(-1);
			else
				System.out.print(startToB + BtoA + AtoEnd);
		} else if (startToB == -1 || BtoA == -1 || AtoEnd == -1) {
			if (startToA == -1 || AtoB == -1 || BtoEnd == -1)
				System.out.print(-1);
			else
				System.out.print(startToA + AtoB + BtoEnd);
		} else
			System.out.print(Math.min(startToA + AtoB + BtoEnd, startToB + BtoA + AtoEnd));
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