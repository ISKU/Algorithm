/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4196
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
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
			int N = Integer.parseInt(parser.nextToken()) + 1;
			int M = Integer.parseInt(parser.nextToken());

			graph = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N; i++)
				graph.add(new ArrayList<Integer>());

			while (M-- > 0) {
				parser = new StringTokenizer(input.readLine());
				graph.get(Integer.parseInt(parser.nextToken())).add(Integer.parseInt(parser.nextToken()));
			}

			stack = new Stack<Integer>();
			discovered = new int[N];
			sccNumber = new int[N];
			sccCount = 1;
			for (int i = 1; i < N; i++)
				if (discovered[i] == 0)
					scc(i);

			int[] indegree = new int[sccCount];
			for (int source = 1; source < N; source++)
				for (int sink : graph.get(source))
					if (sccNumber[source] != sccNumber[sink])
						indegree[sccNumber[sink]]++;

			int answer = 0;
			for (int i = 1; i < sccCount; i++)
				if (indegree[i] == 0)
					answer++;
			System.out.println(answer);
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
			while (true) {
				int vertex = stack.pop();
				sccNumber[vertex] = sccCount;
				if (vertex == source)
					break;
			}
			sccCount++;
		}

		return result;
	}
}