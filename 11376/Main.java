/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.26
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11376
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	private static ArrayList<ArrayList<Integer>> network;
	private static int[] source;
	private static int[] sink;
	private static boolean[] visited;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		network = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N * 2 + 1; i++)
			network.add(new ArrayList<Integer>());

		for (int u = 1; u <= N; u++) {
			for (int i = input.nextInt(); i > 0; i--) {
				int v = input.nextInt();
				network.get(u).add(v);
				network.get(u + N).add(v);
			}
		}

		int match = 0;
		source = new int[N * 2 + 1];
		sink = new int[M + 1];
		Arrays.fill(source, -1);
		Arrays.fill(sink, -1);
		for (int i = 1; i <= N * 2; i++) {
			if (source[i] == -1) {
				visited = new boolean[N * 2 + 1];
				if (dfs(i))
					match++;
			}
		}

		System.out.println(match);
	}

	private static boolean dfs(int cur) {
		visited[cur] = true;

		for (int dest : network.get(cur)) {
			if (sink[dest] == -1 || !visited[sink[dest]] && dfs(sink[dest])) {
				source[cur] = dest;
				sink[dest] = cur;
				return true;
			}
		}

		return false;
	}
}