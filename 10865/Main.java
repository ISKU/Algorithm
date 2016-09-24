
/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10865
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {

	private static LinkedList<Integer>[] graph;

	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int vertices = Integer.parseInt(parser.nextToken());
		int edges = Integer.parseInt(parser.nextToken());

		graph = (LinkedList<Integer>[]) new LinkedList[vertices + 1];
		for (int i = 0; i <= vertices; i++)
			graph[i] = new LinkedList<Integer>();

		while (edges-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int firstVertex = Integer.parseInt(parser.nextToken());
			int secondVertex = Integer.parseInt(parser.nextToken());
			graph[firstVertex].add(secondVertex);
			graph[secondVertex].add(firstVertex);
		}

		for (int vertex = 1; vertex <= vertices; vertex++)
			output.append(graph[vertex].size() + "\n");

		System.out.print(output);
	}
}