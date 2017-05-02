/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.03
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4386
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	private static ArrayList<ArrayList<Edge>> edges;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		Star[] star = new Star[n];
		for (int i = 0; i < n; i++)
			star[i] = new Star(input.nextDouble(), input.nextDouble());

		edges = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < n; i++)
			edges.add(new ArrayList<Edge>());

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				edges.get(i).add(new Edge(i, j, Math.hypot(star[i].x - star[j].x, star[i].y - star[j].y)));
				edges.get(j).add(new Edge(j, i, Math.hypot(star[i].x - star[j].x, star[i].y - star[j].y)));
			}
		}

		System.out.printf("%.2f", prim());
	}

	private static double prim() {
		boolean[] visited = new boolean[edges.size()];
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

		visited[0] = true;
		for (Edge edge : edges.get(0))
			queue.add(edge);

		double cost = 0;
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();

			if (!visited[cur.sink]) {
				visited[cur.sink] = true;
				cost += cur.distance;

				for (Edge edge : edges.get(cur.sink))
					queue.add(edge);
			}
		}

		return cost;
	}

	private static class Star {
		public double x;
		public double y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class Edge implements Comparable<Edge> {
		public int source;
		public int sink;
		public double distance;

		public Edge(int source, int sink, double distance) {
			this.source = source;
			this.sink = sink;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge compare) {
			if (this.distance < compare.distance)
				return -1;
			else if (this.distance > compare.distance)
				return 1;
			else
				return 0;
		}
	}
}