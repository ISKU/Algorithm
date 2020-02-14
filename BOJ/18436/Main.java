/*
 * Author: Minho Kim (ISKU)
 * Date: February 14, 2020
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18436
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[] tree;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			update(i, n);
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				update(i, x);
			} else if (cmd == 2) {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int sum = r - l + 1 - sum(1, H, 1, l, r);
				bw.write(String.valueOf(sum));
				bw.write('\n');
			} else if (cmd == 3) {
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int sum = sum(1, H, 1, l, r);
				bw.write(String.valueOf(sum));
				bw.write('\n');
			}
		}

		bw.close();
	}

	private static void update(int i, int x) {
		i += H - 1;
		tree[i] = x % 2;

		while (i > 0) {
			i /= 2;
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}

	private static int sum(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}
}
