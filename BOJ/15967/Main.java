/*
 * Author: Minho Kim (ISKU)
 * Date: August 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15967
 */

import java.util.*;
import java.io.*;

public class Main {

	private static long[] tree, lazy;
	private static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		lazy = new long[H * 2];
		tree = new long[H * 2];
		for (int i = 1; i <= N; i++)
			update(1, H, 1, i, i, Long.parseLong(st.nextToken()));

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				bw.write(sum(1, H, 1, n, m) + "\n");
			}
			if (command == 2) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				update(1, H, 1, s, e, l);
			}
		}

		bw.close();
	}

	private static long sum(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int l, int r, int i, int L, int R, long value) {
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
		tree[i] = tree[i * 2] + tree[i * 2 + 1];
	}

	private static void propagate(int l, int r, int i) {
		if (lazy[i] == 0)
			return;

		if (i < H) {
			lazy[i * 2] += lazy[i];
			lazy[i * 2 + 1] += lazy[i];
		}

		tree[i] += (r - l + 1) * lazy[i];
		lazy[i] = 0;
	}
}