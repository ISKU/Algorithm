/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1517
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Node[] node;
	private static long[] tree;
	private static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new long[N + 1];
		node = new Node[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			node[i] = new Node(i, Integer.parseInt(st.nextToken()));

		Arrays.sort(node, 1, N + 1);

		long answer = 0;
		for (int i = 1; i <= N; i++) {
			answer += sum(node[i].index);
			update(node[i].index);
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