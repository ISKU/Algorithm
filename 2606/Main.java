/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.08
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2606
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static LinkedList<Integer>[] graph;
	private static int numberOfVertices;
	private static int numberOfEdges;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		numberOfVertices = input.nextInt();
		numberOfEdges = input.nextInt();

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

		System.out.println(exerciseBreadthFirstSearch(1));
	}

	private static int exerciseBreadthFirstSearch(int currentVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] saveVisitedVertices = new boolean[numberOfVertices + 1]; // save visited vertices
		int numberOfVirusComputers = 0;

		// first vertex
		saveVisitedVertices[currentVertex] = true;
		queue.add(currentVertex);

		while (!queue.isEmpty()) {
			currentVertex = queue.poll();
			for (int iterator = 0; iterator < graph[currentVertex].size(); iterator++) {
				int vertex = graph[currentVertex].get(iterator);
				if (saveVisitedVertices[vertex] == false) { // visit
					saveVisitedVertices[vertex] = true;
					queue.add(vertex);
					numberOfVirusComputers++;
				}
			}
		}

		return numberOfVirusComputers;
	}
}