/*
 * Author: Minho Kim (ISKU)
 * Date: February 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/932/B
 */

import java.util.*;
import java.io.*;

public class B {

	private static Node[] tree;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		H = 1 << (int) Math.ceil(Math.log(1000000) / Math.log(2));
		tree = new Node[H * 2];
		for (int i = 0; i < tree.length; i++)
			tree[i] = new Node();

		for (int i = 1; i <= 1000000; i++) {
			int result = i;

			while (result >= 10) {
				int temp = result;
				int sum = 1;

				while (temp > 0) {
					sum *= (temp % 10 == 0) ? 1 : temp % 10;
					temp /= 10;
				}

				result = sum;
			}

			update(i, result);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			bw.write(String.valueOf(sum(1, H, 1, l, r, k)));
			bw.newLine();
		}

		bw.close();
	}

	private static int sum(int l, int r, int i, int L, int R, int k) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i].count[k];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R, k) + sum(mid + 1, r, i * 2 + 1, L, R, k);
	}

	private static void update(int i, int k) {
		i += H - 1;
		tree[i].count[k]++;

		while (i > 1) {
			i /= 2;
			tree[i].count[k] = tree[i * 2].count[k] + tree[i * 2 + 1].count[k];
		}
	}

	private static class Node {
		public int[] count = new int[10];
	}
}