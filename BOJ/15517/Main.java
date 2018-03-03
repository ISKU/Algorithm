/*
 * Author: Minho Kim (ISKU)
 * Date: March 3, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15517
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree, answer;
	private static Node[] node;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];
		node = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			node[i] = new Node(i, Integer.parseInt(br.readLine()));
			tree[H + i - 1] = 1;
		}
		for (int i = H - 1; i >= 1; i--)
			tree[i] = tree[i * 2] + tree[i * 2 + 1];

		Arrays.sort(node, 1, N + 1);
		answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			update(node[i].idx);
			answer[node[i].idx] = sum(1, H, 1, 1, node[i].idx);
		}

		for (int i = 1; i <= N; i++)
			bw.write(answer[i] + "\n");
		bw.close();
	}

	private static int sum(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int i) {
		i += H - 1;
		tree[i] = 0;

		while (i > 1) {
			i /= 2;
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}

	private static class Node implements Comparable<Node> {
		public int idx;
		public int value;

		public Node(int i, int value) {
			this.idx = i;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			if (this.value > o.value)
				return -1;
			else if (this.value < o.value)
				return 1;
			else
				return this.idx - o.idx;
		}
	}
}