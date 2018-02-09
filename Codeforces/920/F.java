/*
 * Author: Minho Kim (ISKU)
 * Date: February 02, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/920/F
 */

import java.util.*;
import java.io.*;

public class F {

	private static int[] divisor;
	private static long[] tree;
	private static boolean[] change;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		divisor = new int[1000001];
		for (int i = 1; i <= 1000000; i++)
			for (int j = i; j <= 1000000; j += i)
				divisor[j]++;

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[H * 2];
		change = new boolean[H * 2];
		st = new StringTokenizer(br.readLine());
		for (int i = H; st.hasMoreTokens(); i++) {
			long element = Long.parseLong(st.nextToken());
			if (element <= 2)
				change[i] = true;
			tree[i] = element;
		}
		for (int i = H - 1; i >= 1; i--)
			tree[i] = tree[i * 2] + tree[i * 2 + 1];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			if (t == 1)
				update(1, H, 1, l, r);
			if (t == 2) {
				bw.write(String.valueOf(sum(1, H, 1, l, r)));
				bw.newLine();
			}
		}

		bw.close();
	}

	private static long sum(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return;
		if (change[i])
			return;
		if (l == r) {
			tree[i] = divisor[(int) tree[i]];
			if (tree[i] <= 2)
				change[i] = true;
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R);
		update(mid + 1, r, i * 2 + 1, L, R);
		tree[i] = tree[i * 2] + tree[i * 2 + 1];
		change[i] = change[i * 2] & change[i * 2 + 1];
	}
}