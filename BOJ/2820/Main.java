/*
 * Author: Minho Kim (ISKU)
 * Date: July 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2820
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static int[] segtree, lazy, salary, start, end;
	private static boolean[] visited;
	private static int H, order;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		salary = new int[N + 1];
		salary[1] = Integer.parseInt(br.readLine());
		for (int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			salary[i] = pay;
			tree[i].add(parent);
			tree[parent].add(i);
		}

		visited = new boolean[N + 1];
		start = new int[N + 1];
		end = new int[N + 1];
		dfs(1);

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		lazy = new int[H * 2];
		segtree = new int[H * 2];
		for (int i = 1; i <= N; i++)
			update(1, H, 1, start[i], start[i], salary[i]);

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);

			if (command == 'p') {
				int a = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (start[a] == end[a])
					continue;
				update(1, H, 1, start[a] + 1, end[a], x);
			}
			if (command == 'u') {
				int a = Integer.parseInt(st.nextToken());
				bw.write(sum(1, H, 1, start[a], start[a]) + "\n");
			}
		}

		bw.close();
	}

	private static int sum(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return segtree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int l, int r, int i, int L, int R, int value) {
		propagate(l, r, i);

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
		segtree[i] = segtree[i * 2] + segtree[i * 2 + 1];
	}

	private static void propagate(int l, int r, int i) {
		if (lazy[i] == 0)
			return;

		if (i < H) {
			lazy[i * 2] += lazy[i];
			lazy[i * 2 + 1] += lazy[i];
		}
		segtree[i] += (r - l + 1) * lazy[i];
		lazy[i] = 0;
	}

	private static void dfs(int u) {
		visited[u] = true;

		start[u] = ++order;
		for (int v : tree[u])
			if (!visited[v])
				dfs(v);
		end[u] = order;
	}
}