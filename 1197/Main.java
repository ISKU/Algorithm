/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1197
 */

import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {

	private static PriorityQueue<Edge> graph = new PriorityQueue<Edge>();
	private static int[] parentTree;
	private static int numberOfVertices;
	private static int numberOfEdges;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfVertices = input.nextInt(); // the number of vertices
		numberOfEdges = input.nextInt(); // the number of edges

		// graph, parent tree initialization
		parentTree = new int[numberOfVertices];
		for (int index = 0; index < numberOfVertices; index++)
			parentTree[index] = -1;

		// input weight graph, Edge(firstVertex, secondVertex, weight)
		for (int count = 0; count < numberOfEdges; count++)
			graph.add(new Edge(input.nextInt() - 1, input.nextInt() - 1, input.nextInt())); // sort by weight

		System.out.println(exerciseKruskal()); // output, minimum cost
	}

	private static int exerciseKruskal() {
		int minimumCost = 0, edgeCount = 0;

		while (!graph.isEmpty() && edgeCount < numberOfVertices - 1) {
			Edge leastCostEdge = graph.poll();
			int indexSetV = collapsingFind(leastCostEdge.vertexV);
			int indexSetW = collapsingFind(leastCostEdge.vertexW);
			if (indexSetV != indexSetW) {
				weightedUnion(indexSetV, indexSetW);
				minimumCost = minimumCost + leastCostEdge.weight;
				edgeCount++;
			}
		}

		return minimumCost; // return minimum cost
	}

	private static void weightedUnion(int indexSetV, int indexSetW) {
		int unionSize = parentTree[indexSetV] + parentTree[indexSetW];

		if (parentTree[indexSetV] > parentTree[indexSetW]) {
			parentTree[indexSetV] = indexSetW;
			parentTree[indexSetW] = unionSize;
		} else {
			parentTree[indexSetW] = indexSetV;
			parentTree[indexSetV] = unionSize;
		}
	}

	private static int collapsingFind(int index) {
		int root, child, next;

		for (root = index; parentTree[root] >= 0; root = parentTree[root])
			;

		for (child = index; child != root; child = next) {
			next = parentTree[child];
			parentTree[child] = root;
		}

		return root;
	}

	private static class Edge implements Comparable<Edge> {
		public int vertexV;
		public int vertexW;
		public int weight;

		public Edge(int vertexV, int vertexW, int weight) {
			this.vertexV = vertexV;
			this.vertexW = vertexW;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge compare) {
			if (this.weight < compare.weight)
				return -1;
			else if (this.weight > compare.weight)
				return 1;
			else
				return 0;
		}
	}
}