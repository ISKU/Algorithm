/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1395
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree;
	private static boolean[] lazy;
	private static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];
		lazy = new boolean[H * 2];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			if (o == 0)
				update(1, H, 1, s, t);
			if (o == 1) {
				bw.write(String.valueOf(sum(1, H, 1, s, t)));
				bw.write('\n');
			}
		}

		bw.close();
	}

	private static int sum(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int l, int r, int i, int L, int R) {
		propagate(l, r, i);

		if (r < L || R < l)
			return;
		if (L <= l && r <= R) {
			lazy[i] = !lazy[i];
			propagate(l, r, i);
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R);
		update(mid + 1, r, i * 2 + 1, L, R);
		tree[i] = tree[i * 2] + tree[i * 2 + 1];
	}

	private static void propagate(int l, int r, int i) {
		if (!lazy[i])
			return;

		if (i < H) {
			lazy[i * 2] ^= lazy[i];
			lazy[i * 2 + 1] ^= lazy[i];
		}

		tree[i] = Math.abs(tree[i] - (r - l + 1));
		lazy[i] = !lazy[i];
	}
}
