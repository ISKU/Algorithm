/*
 * Author: Minho Kim (ISKU)
 * Date: February 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14428
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[][] tree;
	private static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2][2];
		for (int i = H; i < tree.length; i++) {
			tree[i][0] = i - H + 1;
			tree[i][1] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= N; i++)
			update(i, Integer.parseInt(st.nextToken()));
		for (int i = N + 1; i <= H; i++)
			update(i, Integer.MAX_VALUE);

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				update(i, v);
			}
			if (cmd == 2) {
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());

				int[] answer = min(1, H, 1, L, R);
				bw.write(String.valueOf(answer[0]));
				bw.write('\n');
			}
		}

		bw.close();
	}

	private static int[] min(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return new int[] { H + 1, Integer.MAX_VALUE };
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		int[] left = min(l, mid, i * 2, L, R);
		int[] right = min(mid + 1, r, i * 2 + 1, L, R);

		if (left[1] < right[1])
			return left;
		else if (left[1] > right[1])
			return right;
		else {
			if (left[0] < right[0])
				return left;
			else
				return right;
		}
	}

	private static void update(int i, int value) {
		i += H - 1;
		tree[i][1] = value;

		while (i > 0) {
			i /= 2;
			int[] left = tree[i * 2];
			int[] right = tree[i * 2 + 1];

			if (left[1] < right[1]) {
				tree[i][0] = left[0];
				tree[i][1] = left[1];
			} else if (left[1] > right[1]) {
				tree[i][0] = right[0];
				tree[i][1] = right[1];
			} else {
				tree[i][0] = Math.min(left[0], right[0]);
				tree[i][1] = left[1];
			}
		}
	}
}