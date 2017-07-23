/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3977
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static ArrayList<SortedSet<Integer>> scc;
	private static Stack<Integer> stack;
	private static int[] discovered;
	private static int[] sccNumber;
	private static int sccCount, vertexCount;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int testCase = Integer.parseInt(parser.nextToken());

		while (testCase-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(parser.nextToken());
			int M = Integer.parseInt(parser.nextToken());

			graph = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N; i++)
				graph.add(new ArrayList<Integer>());

			while (M-- > 0) {
				parser = new StringTokenizer(input.readLine());
				graph.get(Integer.parseInt(parser.nextToken())).add(Integer.parseInt(parser.nextToken()));
			}

			scc = new ArrayList<SortedSet<Integer>>();
			stack = new Stack<Integer>();
			discovered = new int[N];
			sccNumber = new int[N];
			sccCount = 1;
			for (int i = 0; i < N; i++)
				if (discovered[i] == 0)
					scc(i);

			int[] indegree = new int[sccCount];
			for (int source = 0; source < N; source++)
				for (int sink : graph.get(source))
					if (sccNumber[source] != sccNumber[sink])
						indegree[sccNumber[sink]]++;

			int zero = 0;
			for (int i = 1; i < sccCount; i++)
				if (indegree[i] == 0)
					zero++;

			if (zero == 1) {
				for (int i = 1; i < sccCount; i++)
					if (indegree[i] == 0)
						for (int vertex : scc.get(i - 1))
							System.out.println(vertex);
			} else
				System.out.println("Confused");
			System.out.println();

			if (testCase != 0)
				input.readLine();
		}
	}

	private static int scc(int source) {
		int result = discovered[source] = ++vertexCount;
		stack.push(source);

		for (int sink : graph.get(source)) {
			if (discovered[sink] == 0)
				result = Math.min(result, scc(sink));
			else if (sccNumber[sink] == 0)
				result = Math.min(result, discovered[sink]);
		}

		if (result == discovered[source]) {
			SortedSet<Integer> curScc = new TreeSet<Integer>();

			while (true) {
				int vertex = stack.pop();
				curScc.add(vertex);
				sccNumber[vertex] = sccCount;
				if (vertex == source)
					break;
			}

			scc.add(curScc);
			sccCount++;
		}

		return result;
	}
}