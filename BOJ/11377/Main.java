/*
 * Author: Minho Kim (ISKU)
 * Date: December 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11377
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] network;
	private static int[] source;
	private static int[] sink;
	private static boolean[] visited;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		network = new ArrayList[N * 2 + 1];
		for (int i = 0; i < network.length; i++)
			network[i] = new ArrayList<Integer>();

		for (int u = 1; u <= N; u++) {
			st = new StringTokenizer(br.readLine());
			for (int i = Integer.parseInt(st.nextToken()); i > 0; i--) {
				int v = Integer.parseInt(st.nextToken());
				network[u].add(v);
				network[u + N].add(v);
			}
		}

		int total = 0;
		source = new int[N * 2 + 1];
		sink = new int[M + 1];
		Arrays.fill(source, -1);
		Arrays.fill(sink, -1);
		for (int i = 1; i <= N; i++) {
			if (source[i] == -1) {
				visited = new boolean[N * 2 + 1];
				if (dfs(i))
					total++;
			}
		}

		int match = 0;
		for (int i = N + 1; i <= N * 2; i++) {
			if (source[i] == -1) {
				visited = new boolean[N * 2 + 1];
				if (dfs(i))
					match++;
				if (match == K)
					break;
			}
		}

		System.out.print(total + match);
	}

	private static boolean dfs(int cur) {
		visited[cur] = true;

		for (int dest : network[cur]) {
			if (sink[dest] == -1 || !visited[sink[dest]] && dfs(sink[dest])) {
				source[cur] = dest;
				sink[dest] = cur;
				return true;
			}
		}

		return false;
	}
}
