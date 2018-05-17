/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8980
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree, lazy;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		Node[] node = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			node[i] = new Node(u, v, w);
		}

		Arrays.sort(node, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.v != o2.v)
					return o1.v - o2.v;
				else
					return o1.u - o2.u;
			}
		});

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];
		lazy = new int[H * 2];
		long sum = 0;
		for (int i = 0; i < M; i++) {
			int u = node[i].u;
			int v = node[i].v;
			int w = node[i].w;

			int max = max(1, H, 1, u, v - 1);
			int capacity = C - max;
			if (capacity <= 0)
				continue;
			if (w > capacity)
				w = capacity;

			update(1, H, 1, u, v - 1, w);
			sum += w;
		}

		System.out.print(sum);
	}

	private static void update(int l, int r, int i, int L, int R, int value) {
		if (r < L || R < l)
			return;
		if (L <= l && r <= R) {
			lazy[i] += value;
			propagate(l, r, i);
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R, value);
		update(mid + 1, r, i * 2 + 1, L, R, value);
		tree[i] = Math.max(tree[i * 2], tree[i * 2 + 1]);
	}

	private static int max(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return Integer.MIN_VALUE;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return Math.max(max(l, mid, i * 2, L, R), max(mid + 1, r, i * 2 + 1, L, R));
	}

	private static void propagate(int l, int r, int i) {
		if (lazy[i] == 0)
			return;

		if (i < H) {
			tree[i] = Math.max(tree[i * 2] + lazy[i * 2], tree[i * 2 + 1] + lazy[i * 2 + 1]);
			lazy[i * 2] += lazy[i];
			lazy[i * 2 + 1] += lazy[i];
		}

		tree[i] += lazy[i];
		lazy[i] = 0;
	}

	private static class Node {
		public int u, v, w;

		public Node(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
}