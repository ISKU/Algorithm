/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11724
 */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

	private static LinkedList<Integer>[] graph;
	private static boolean[] saveVisitedVertices;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfVertices = input.nextInt(); // number of vertices
		int numberOfEdges = input.nextInt(); // number of edges
		int numberOfConnectedComponents = 0; // output count
		saveVisitedVertices = new boolean[numberOfVertices + 1]; // visited vertices, initialization

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

		// find connected components
		for (int currentVertex = 1; currentVertex <= numberOfVertices; currentVertex++)
			if (saveVisitedVertices[currentVertex] == false) {
				saveVisitedVertices[currentVertex] = true;
				exerciseDepthFirstSearch(currentVertex); // dfs
				numberOfConnectedComponents++;
			}

		System.out.println(numberOfConnectedComponents); // output, number of connected components
	}

	private static void exerciseDepthFirstSearch(int currentVertex) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(currentVertex); // first vertex
		while (stack.isEmpty() == false) {
			currentVertex = stack.pop();
			for (int iterator = 0; iterator < graph[currentVertex].size(); iterator++) {
				int vertex = graph[currentVertex].get(iterator);
				if (saveVisitedVertices[vertex] == false) {
					saveVisitedVertices[vertex] = true;
					stack.push(vertex);
				}
			}
		}
	}
}