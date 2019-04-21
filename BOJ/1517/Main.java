/*
 * Author: Minho Kim (ISKU)
 * Date: April 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1517
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Node[] nodes;
	private static long[] tree;
	private static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new long[N + 1];
		nodes = new Node[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));

		nodes[0] = new Node(0, -1);
		Arrays.sort(nodes, 1, N + 1);

		long answer = 0;
		for (int i = 1; i <= N; i++) {
			if (nodes[i].value == nodes[i - 1].value)
				continue;
			answer += sum(nodes[i].index);
			update(nodes[i].index);
		}

		System.out.print(answer);
	}

	private static long sum(int i) {
		int ret = 0;

		while (i > 0) {
			ret += tree[i];
			i -= (i & -i);
		}

		return ret;
	}

	private static void update(int i) {
		while (i <= N) {
			tree[i]++;
			i += (i & -i);
		}
	}

	private static class Node implements Comparable<Node> {
		public int index;
		public int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value != o.value)
				return o.value - this.value;
			else
				return this.index - o.index;
		}
	}
}
