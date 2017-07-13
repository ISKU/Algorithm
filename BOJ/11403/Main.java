/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.03
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11403
 */

import java.util.Scanner;
import java.util.Stack;

public class Main {

	private static int numberOfVertices;
	private static int[][] graph;
	private static int[][] saveGraphPath;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfVertices = input.nextInt(); // the number of vertices
		graph = new int[numberOfVertices][numberOfVertices];
		saveGraphPath = new int[numberOfVertices][numberOfVertices]; // save graph output

		// input, graph
		for (int i = 0; i < numberOfVertices; i++)
			for (int j = 0; j < numberOfVertices; j++)
				graph[i][j] = input.nextInt();

		// vertices run DFS
		for (int vertex = 0; vertex < numberOfVertices; vertex++)
			exerciseDepthFirstSearch(vertex);

		// output, path
		StringBuilder graphOutput = new StringBuilder();
		for (int i = 0; i < numberOfVertices; i++) {
			for (int j = 0; j < numberOfVertices; j++)
				graphOutput.append(saveGraphPath[i][j] + " ");
			graphOutput.append("\n");
		}
		System.out.println(graphOutput);
	}

	private static void exerciseDepthFirstSearch(int currentVertex) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] VisitedVertices = new boolean[numberOfVertices];
		int firstVertex = currentVertex;

		stack.push(firstVertex); // first vertex, not visited
		while (!stack.isEmpty()) {
			currentVertex = stack.pop();
			for (int visitVertex = 0; visitVertex < numberOfVertices; visitVertex++) {
				if (graph[currentVertex][visitVertex] == 1 && VisitedVertices[visitVertex] == false) {
					VisitedVertices[visitVertex] = true;
					stack.push(visitVertex);
					saveGraphPath[firstVertex][visitVertex] = 1; // Paths that can pass the first vertex
				}
			}
		}
	}
}