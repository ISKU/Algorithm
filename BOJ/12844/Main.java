/*
 * Author: Minho Kim (ISKU)
 * Date: February 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12844
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree, lazy;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];
		lazy = new int[H * 2];
		Arrays.fill(lazy, -1);
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			update(1, H, 1, i, i, Integer.parseInt(st.nextToken()));

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b) {
				int temp = b;
				b = a;
				a = temp;
			}

			if (t == 1)
				update(1, H, 1, a + 1, b + 1, Integer.parseInt(st.nextToken()));
			if (t == 2) {
				bw.write(String.valueOf(sum(1, H, 1, a + 1, b + 1)));
				bw.newLine();
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
		return sum(l, mid, i * 2, L, R) ^ sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int l, int r, int i, int L, int R, int value) {
		propagate(l, r, i);

		if (r < L || R < l)
			return;
		if (L <= l && r <= R) {
			lazy[i] = (lazy[i] == -1) ? value : lazy[i] ^ value;
			propagate(l, r, i);
			return;
		}

		int mid = (l + r) / 2;
		update(l, mid, i * 2, L, R, value);
		update(mid + 1, r, i * 2 + 1, L, R, value);
		tree[i] = tree[i * 2] ^ tree[i * 2 + 1];
	}

	private static void propagate(int l, int r, int i) {
		if (lazy[i] == -1)
			return;

		if (i < H) {
			lazy[i * 2] = (lazy[i * 2] == -1) ? lazy[i] : lazy[i * 2] ^ lazy[i];
			lazy[i * 2 + 1] = (lazy[i * 2 + 1] == -1) ? lazy[i] : lazy[i * 2 + 1] ^ lazy[i];
		}

		if ((r - l + 1) % 2 == 1)
			tree[i] ^= lazy[i];
		lazy[i] = -1;
	}
}