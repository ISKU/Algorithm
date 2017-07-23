/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2150
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static Stack<Integer> stack;
	private static ArrayList<SortedSet<Integer>> scc;
	private static int[] discovered;
	private static boolean[] finished;
	private static int sccCount, vertexCount;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int V = Integer.parseInt(parser.nextToken()) + 1;
		int E = Integer.parseInt(parser.nextToken());

		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<Integer>());

		while (E-- > 0) {
			parser = new StringTokenizer(input.readLine());
			graph.get(Integer.parseInt(parser.nextToken())).add(Integer.parseInt(parser.nextToken()));
		}

		scc = new ArrayList<SortedSet<Integer>>();
		stack = new Stack<Integer>();
		discovered = new int[V];
		finished = new boolean[V];
		for (int i = 1; i < V; i++)
			if (discovered[i] == 0)
				scc(i);

		Collections.sort(scc, new Comparator<SortedSet<Integer>>() {
			@Override
			public int compare(SortedSet<Integer> a, SortedSet<Integer> b) {
				return a.first().compareTo(b.first());
			}
		});

		System.out.println(sccCount);
		for (SortedSet<Integer> curScc : scc) {
			for (int vertex : curScc)
				System.out.printf("%d ", vertex);
			System.out.println("-1");
		}
	}

	private static int scc(int source) {
		int result = discovered[source] = ++vertexCount;
		stack.push(source);

		for (int sink : graph.get(source)) {
			if (discovered[sink] == 0)
				result = Math.min(result, scc(sink));
			else if (!finished[sink])
				result = Math.min(result, discovered[sink]);
		}

		if (result == discovered[source]) {
			SortedSet<Integer> sccSet = new TreeSet<Integer>();

			while (true) {
				int vertex = stack.pop();
				sccSet.add(vertex);
				finished[vertex] = true;
				if (vertex == source)
					break;
			}

			scc.add(sccSet);
			sccCount++;
		}

		return result;
	}
}