/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14950
 */

import java.util.*;
import java.io.*;

public class Main {

	public static ArrayList<ArrayList<Edge>> graph;
	public static boolean[] visited;
	public static PriorityQueue<Edge> queue;
	public static int V, E, T;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		V = Integer.parseInt(parser.nextToken()) + 1;
		E = Integer.parseInt(parser.nextToken());
		T = Integer.parseInt(parser.nextToken());

		graph = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<Edge>());

		for (int i = 0; i < E; i++) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());
			int weight = Integer.parseInt(parser.nextToken());
			graph.get(first).add(new Edge(second, weight));
			graph.get(second).add(new Edge(first, weight));
		}

		System.out.print(prim());
	}

	private static int prim() {
		queue = new PriorityQueue<Edge>();
		visited = new boolean[V];

		for (Edge edge : graph.get(1))
			queue.add(edge);
		visited[1] = true;

		int count = 0;
		int minCost = 0;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();

			if (!visited[edge.vertex]) {
				visited[edge.vertex] = true;
				minCost += edge.weight + (T * count++);

				for (Edge dest : graph.get(edge.vertex))
					queue.add(dest);
			}
		}

		return minCost;
	}

	private static class Edge implements Comparable<Edge> {
		public int vertex;
		public int weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}