/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.06.29
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://algospot.com/judge/problem/read/ARCTIC
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ARCTIC {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			Point[] points = new Point[input.nextInt()];
			for (int i = 0; i < points.length; i++)
				points[i] = new Point(i, input.nextDouble(), input.nextDouble());

			ArrayList<Double> mst = prims(points);
			double answer = 0;
			for (double dist : mst)
				answer = Math.max(answer, dist);

			System.out.printf("%.2f\n", answer);
		}
	}

	private static ArrayList<Double> prims(Point[] points) {
		ArrayList<ArrayList<Point>> graph = new ArrayList<ArrayList<Point>>();
		ArrayList<Double> mst = new ArrayList<Double>();
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[points.length];

		for (int i = 0; i < points.length; i++)
			graph.add(new ArrayList<Point>());

		for (int source = 0; source < points.length; source++)
			for (int sink = 0; sink < points.length; sink++)
				if (source != sink)
					graph.get(source).add(points[sink]);

		visited[0] = true;
		for (Point point : graph.get(0))
			pQueue.add(new Edge(0, point.index, distance(points[0], point)));

		while (!pQueue.isEmpty()) {
			Edge cur = pQueue.poll();

			if (!visited[cur.sink]) {
				visited[cur.sink] = true;
				mst.add(cur.dist);

				for (Point point : graph.get(cur.sink))
					pQueue.add(new Edge(cur.sink, point.index, distance(
							points[cur.sink], point)));
			}
		}

		return mst;
	}

	private static double distance(Point A, Point B) {
		return Math.hypot(B.x - A.x, B.y - A.y);
	}

	private static class Edge implements Comparable<Edge> {
		public int source;
		public int sink;
		public double dist;

		public Edge(int source, int sink, double dist) {
			this.source = source;
			this.sink = sink;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.dist < o.dist)
				return -1;
			else if (this.dist > o.dist)
				return 1;
			else
				return 0;
		}
	}

	private static class Point {
		public int index;
		public double x;
		public double y;

		public Point(int index, double x, double y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}
}