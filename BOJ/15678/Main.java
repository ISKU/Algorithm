/*
 * Author: Minho Kim (ISKU)
 * Date: April 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15678
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int H;
	private static long[] tree;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[H * 2];
		Arrays.fill(tree, Long.MIN_VALUE);

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			update(i, Long.parseLong(st.nextToken()));

		for (int i = 2; i <= N; i++) {
			int start = (i - D <= 1) ? 1 : i - D;
			int end = (i - 1 <= 1) ? 1 : i - 1;
			update(i, Math.max(tree[H + i - 1], max(1, H, 1, start, end) + tree[H + i - 1]));
		}

		System.out.print(max(1, H, 1, 1, N));
	}

	private static long max(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return Integer.MIN_VALUE;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return Math.max(max(l, mid, i * 2, L, R), max(mid + 1, r, i * 2 + 1, L, R));
	}

	private static void update(int i, long value) {
		i += H - 1;
		tree[i] = value;

		while (i > 0) {
			i /= 2;
			tree[i] = Math.max(tree[i * 2], tree[i * 2 + 1]);
		}
	}
}