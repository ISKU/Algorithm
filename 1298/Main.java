/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.27
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1298
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
		for (int i = 0; i < N + M + 1; i++)
			network.add(new ArrayList<Integer>());

		for (int i = 0; i < M; i++)
			network.get(input.nextInt()).add(input.nextInt());

		int match = 0;
		source = new int[N + M + 1];
		sink = new int[N + M + 1];
		Arrays.fill(source, -1);
		Arrays.fill(sink, -1);

		for (int i = 1; i <= N; i++) {
			if (source[i] == -1) {
				visited = new boolean[N + M + 1];
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