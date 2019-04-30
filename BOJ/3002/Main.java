/*
 * Author: Minho Kim (ISKU)
 * Date: April 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3002
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[][] tree;
	private static int[] lazy;
	private static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		lazy = new int[H * 2];
		tree = new int[H * 2][10];
		String number = br.readLine();
		for (int i = 0; i < N; i++)
			tree[i + H][number.charAt(i) - '0'] = 1;
		for (int i = H - 1; i >= 1; i--)
			for (int d = 0; d <= 9; d++)
				tree[i][d] = tree[i * 2][d] + tree[i * 2 + 1][d];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			bw.write(get(1, H, 1, L, R) + "\n");
			update(1, H, 1, L, R);
		}

		bw.close();
	}

	private static void update(int l, int r, int i, int L, int R) {
		propagation(i);

		if (r < L || R < l)
			return;
		if (L <= l && r <= R) {
			lazy[i] += 1;
			propagation(i);
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R);
		update(mid + 1, r, i * 2 + 1, L, R);

		for (int d = 0; d <= 9; d++)
			tree[i][d] = tree[i * 2][d] + tree[i * 2 + 1][d];
	}

	private static int get(int l, int r, int i, int L, int R) {
		propagation(i);

		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R) {
			int sum = 0;
			for (int d = 0; d <= 9; d++)
				sum += tree[i][d] * d;

			return sum;
		}

		int mid = (l + r) / 2;
		return get(l, mid, i * 2, L, R) + get(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void propagation(int i) {
		if (lazy[i] == 0)
			return;

		int[] temp = Arrays.copyOf(tree[i], 10);
		for (int d = 0; d <= 9; d++)
			tree[i][(d + lazy[i]) % 10] = temp[d];

		if (i < H) {
			lazy[i * 2] += lazy[i];
			lazy[i * 2 + 1] += lazy[i];
		}
		lazy[i] = 0;
	}
}