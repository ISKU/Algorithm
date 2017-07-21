/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.21
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1613
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static ArrayList<ArrayList<Integer>> reverse;
	private static boolean[] visited;
	private static int answer;
	private static boolean out;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(parser.nextToken()) + 1;
		int k = Integer.parseInt(parser.nextToken());

		graph = new ArrayList<ArrayList<Integer>>();
		reverse = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
			reverse.add(new ArrayList<Integer>());
		}

		while (k-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());
			graph.get(first).add(second);
			reverse.get(second).add(first);
		}

		int s = Integer.parseInt(input.readLine());
		while (s-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());

			answer = 0;
			boolean[] oper = new boolean[] { true, false };
			for (int i = 0; i < oper.length; i++) {
				if (answer == 0) {
					out = false;
					visited = new boolean[n];
					dfs(first, second, oper[i]);
				}
			}

			output.write(String.format("%d\n", answer));
		}

		output.close();
	}

	private static void dfs(int src, int goal, boolean direction) {
		if (out || src == goal) {
			answer = (direction) ? -1 : 1;
			out = true;
			return;
		}

		visited[src] = true;
		for (int sink : (direction) ? graph.get(src) : reverse.get(src))
			if (!visited[sink])
				dfs(sink, goal, direction);
	}
}