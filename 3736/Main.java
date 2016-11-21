/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.11.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3736
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

	private static final int MAX = 10000;
	private static final int INFINITY = Integer.MAX_VALUE;
	private static int N;
	private static int[] A = new int[MAX];
	private static int[] B = new int[MAX];
	private static int[] distance = new int[MAX];
	private static boolean[] used = new boolean[MAX];
	private static Vector<Integer>[] graph = (Vector<Integer>[]) new Vector[MAX];;

	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		for (int i = 0; i < graph.length; i++)
			graph[i] = new Vector<Integer>();

		while ((line = input.readLine()) != null) {
			N = Integer.parseInt(line);
			for (int i = 0; i < N; i++) {
				StringTokenizer parser = new StringTokenizer(input.readLine());
				int job = Integer.parseInt(parser.nextToken(":"));
				int J = Integer.parseInt(parser.nextToken(")").split("[(]")[1]);

				parser.nextToken(" ");
				for (int j = 0; j < J; j++) {
					int server = Integer.parseInt(parser.nextToken());
					graph[job].add(server - N);
				}
			}

			int match = 0;
			for (int i = 0; i < A.length; i++)
				A[i] = -1;
			for (int i = 0; i < B.length; i++)
				B[i] = -1;

			while (true) {
				bfs();

				int flow = 0;
				for (int i = 0; i < N; i++)
					if (!used[i] && dfs(i))
						flow++;

				if (flow == 0)
					break;
				match += flow;
			}
			System.out.printf("%d\n", match);

			used = new boolean[used.length];
			for (int i = 0; i < N; i++)
				graph[i].clear();
		}
	}

	private static void bfs() {
		Queue<Integer> Q = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				distance[i] = 0;
				Q.add(i);
			} else
				distance[i] = INFINITY;
		}

		while (!Q.isEmpty()) {
			int a = Q.peek();
			Q.poll();
			for (int b : graph[a]) {
				if (B[b] != -1 && distance[B[b]] == INFINITY) {
					distance[B[b]] = distance[a] + 1;
					Q.add(B[b]);
				}
			}
		}
	}

	private static boolean dfs(int a) {
		for (int b : graph[a]) {
			if (B[b] == -1 || distance[B[b]] == distance[a] + 1 && dfs(B[b])) {
				used[a] = true;
				A[a] = b;
				B[b] = a;
				return true;
			}
		}
		return false;
	}
}