/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.29
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1260
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static LinkedList<Integer>[] graph;
	private static int numberOfVertices;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfVertices = input.nextInt(); // number of vertices
		int numberOfEdges = input.nextInt(); // number of edges
		int vertex = input.nextInt(); // first vertex

		// graph, initialization
		graph = (LinkedList<Integer>[]) new LinkedList[numberOfVertices + 1];
		for (int i = 0; i <= numberOfVertices; i++)
			graph[i] = new LinkedList<Integer>();

		// input graph
		for (int i = 1; i <= numberOfEdges; i++) {
			int firstVertex = input.nextInt();
			int secondVertex = input.nextInt();
			graph[firstVertex].add(secondVertex);
			graph[secondVertex].add(firstVertex);
		}

		// sort the graph to visit a small number of vertices that first.
		for (int i = 1; i <= numberOfVertices; i++)
			Collections.sort(graph[i]);

		exerciseDepthFirstSearch(vertex); // ouput, dfs path
		System.out.println();
		System.out.println(exerciseBreadthFirstSearch(vertex)); // output, bfs path
	}

	private static void exerciseDepthFirstSearch(int currentVertex) {
		boolean[] saveVisitedVertices = new boolean[numberOfVertices + 1]; // save visited vertices
		recursiveDFS(saveVisitedVertices, currentVertex); // run dfs
	}

	private static void recursiveDFS(boolean[] saveVisitedVertices, int currentVertex) {
		if (saveVisitedVertices[currentVertex]) // visited all vertex
			return;

		System.out.print(currentVertex + " "); // output
		saveVisitedVertices[currentVertex] = true;

		for (int iterator = 0; iterator < graph[currentVertex].size(); iterator++) {
			int vertex = graph[currentVertex].get(iterator);
			if (saveVisitedVertices[vertex] == false) // visit
				recursiveDFS(saveVisitedVertices, vertex);
		}
	}

	private static String exerciseBreadthFirstSearch(int currentVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder path = new StringBuilder(); // path of the visited vertices
		boolean[] saveVisitedVertices = new boolean[numberOfVertices + 1]; // save visited vertices

		// first vertex
		saveVisitedVertices[currentVertex] = true;
		queue.add(currentVertex);

		while (!queue.isEmpty()) {
			currentVertex = queue.poll();
			path.append(currentVertex + " ");
			for (int iterator = 0; iterator < graph[currentVertex].size(); iterator++) {
				int vertex = graph[currentVertex].get(iterator);
				if (saveVisitedVertices[vertex] == false) { // visit
					saveVisitedVertices[vertex] = true;
					queue.add(vertex);
				}
			}
		}

		return path.toString();
	}
}