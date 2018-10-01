/*
 * Author: Minho Kim (ISKU)
 * Date: October 2, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10565
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static Node[] segtree;
	private static int[] lazy, start, end;
	private static int H, order;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			tree = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				tree[i] = new ArrayList<Integer>();
			for (int u = 2; u <= N; u++) {
				int v = Integer.parseInt(st.nextToken());
				tree[u].add(v);
				tree[v].add(u);
			}

			order = 0;
			start = new int[N + 1];
			end = new int[N + 1];
			dfs(1);

			st = new StringTokenizer(br.readLine());
			H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
			lazy = new int[H * 2];
			segtree = new Node[H * 2];
			for (int i = 1; i <= N; i++) {
				int salary = Integer.parseInt(st.nextToken());
				segtree[H + start[i] - 1] = new Node(salary, salary);
			}
			for (int i = H + N; i < segtree.length; i++)
				segtree[i] = new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
			for (int i = H - 1; i >= 1; i--) {
				Node l = segtree[i * 2];
				Node r = segtree[i * 2 + 1];
				segtree[i] = new Node(Math.min(l.min, r.min), Math.max(l.max, r.max));
			}

			int Q = Integer.parseInt(br.readLine());
			while (Q-- > 0) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();

				if ("R".equals(command)) {
					int v = Integer.parseInt(st.nextToken());
					int salary = Integer.parseInt(st.nextToken());
					update(1, H, 1, start[v], end[v], salary);
				}
				if ("Q".equals(command)) {
					int v = Integer.parseInt(st.nextToken());
					int min = min(1, H, 1, start[v], end[v]);
					int max = max(1, H, 1, start[v], end[v]);
					bw.write(String.valueOf(max - min));
					bw.write("\n");
				}
			}
		}

		bw.close();
	}

	private static int min(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return Integer.MAX_VALUE;
		if (L <= l && r <= R)
			return segtree[i].min;

		int mid = (l + r) / 2;
		return Math.min(min(l, mid, i * 2, L, R), min(mid + 1, r, i * 2 + 1, L, R));
	}

	private static int max(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return Integer.MIN_VALUE;
		if (L <= l && r <= R)
			return segtree[i].max;

		int mid = (l + r) / 2;
		return Math.max(max(l, mid, i * 2, L, R), max(mid + 1, r, i * 2 + 1, L, R));
	}

	private static void update(int l, int r, int i, int L, int R, int salary) {
		propagate(l, r, i);

		if (r < L || R < l)
			return;
		if (L <= l && r <= R) {
			lazy[i] += salary;
			propagate(l, r, i);
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R, salary);
		update(mid + 1, r, i * 2 + 1, L, R, salary);
		segtree[i].min = Math.min(segtree[i * 2].min, segtree[i * 2 + 1].min);
		segtree[i].max = Math.max(segtree[i * 2].max, segtree[i * 2 + 1].max);
	}

	private static void propagate(int l, int r, int i) {
		if (lazy[i] == 0)
			return;

		if (i < H) {
			lazy[i * 2] += lazy[i];
			lazy[i * 2 + 1] += lazy[i];
		}

		segtree[i].min += lazy[i];
		segtree[i].max += lazy[i];
		lazy[i] = 0;
	}

	private static void dfs(int u) {
		start[u] = ++order;
		for (int v : tree[u])
			if (start[v] == 0)
				dfs(v);
		end[u] = order;
	}

	private static class Node {
		public int min, max;

		public Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}
}