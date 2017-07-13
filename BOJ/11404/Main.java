/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11404
 */

import java.util.Scanner;

public class Main {

	private static Vertex[] graph = new Vertex[100001];
	private static int numberOfVertices;
	private static int numberOfEdges;
	private static final int INFINITY = Integer.MAX_VALUE;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfVertices = input.nextInt();
		numberOfEdges = input.nextInt();

		for (int count = 0; count < numberOfEdges; count++)
			link(input.nextInt(), input.nextInt(), input.nextInt());

		// run dijkstra
		for (int vertex = 1; vertex <= numberOfVertices; vertex++) {
			int[] dist = exerciseDijkstra(vertex);

			StringBuilder output = new StringBuilder();
			for (int index = 1; index < dist.length; index++)
				output.append((dist[index] == INFINITY) ? "INF\n" : dist[index] + " ");
			System.out.println(output);
		}
	}

	private static int[] exerciseDijkstra(int firstVertex) {
		int[] dist = new int[numberOfVertices + 1];
		int[] prev = new int[numberOfVertices + 1];
		boolean[] mark = new boolean[numberOfVertices + 1];

		int distVertexIndex = firstVertex;
		for (int vertex = 1; vertex <= numberOfVertices; vertex++)
			if (vertex != distVertexIndex)
				dist[vertex] = INFINITY;

		while (distVertexIndex != -1) {
			mark[distVertexIndex] = true;
			for (Vertex vertex = graph[distVertexIndex]; vertex != null; vertex = vertex.next)
				if (!mark[vertex.index] && dist[distVertexIndex] + vertex.weight < dist[vertex.index])
					dist[vertex.index] = dist[distVertexIndex] + vertex.weight;
			distVertexIndex = findSmallestDist(dist, mark);
		}

		return dist;
	}

	private static int findSmallestDist(int[] dist, boolean[] mark) {
		int min = INFINITY;
		int distindex = -1;

		for (int i = 1; i <= numberOfVertices; i++)
			if (!mark[i] && dist[i] < min) {
				min = dist[i];
				distindex = i;
			}

		return distindex;
	}

	private static void link(int vertexU, int vertexV, int weight) {
		graph[vertexU] = new Vertex(vertexV, weight, graph[vertexU]);
	}

	private static class Vertex {
		public int index;
		public int weight;
		public Vertex next;

		public Vertex(int index, int weight, Vertex next) {
			this.index = index;
			this.weight = weight;
			this.next = next;
		}
	}
}