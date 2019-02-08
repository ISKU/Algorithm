/*
 * Author: Minho Kim (ISKU)
 * Date: February 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13544
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
		tree = new int[H * 2][];
		for (int i = 0; i < N; i++)
			tree[i + H] = new int[] { Integer.parseInt(st.nextToken()) };
		for (int i = N + H; i < tree.length; i++)
			tree[i] = new int[] { 0 };
		build(1, H, 1);

		int M = Integer.parseInt(br.readLine());
		int answer = 0;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()) ^ answer;
			int R = Integer.parseInt(st.nextToken()) ^ answer;
			int K = Integer.parseInt(st.nextToken()) ^ answer;

			answer = count(1, H, 1, L, R, K);
			bw.write(String.valueOf(answer));
			bw.write('\n');
		}

		bw.close();
	}

	private static int count(int l, int r, int i, int L, int R, int K) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return upperBound(i, K);

		int mid = (l + r) / 2;
		return count(l, mid, i * 2, L, R, K) + count(mid + 1, r, i * 2 + 1, L, R, K);
	}

	private static int upperBound(int i, int K) {
		int l = 0;
		int r = tree[i].length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (tree[i][mid] <= K)
				l = mid + 1;
			else
				r = mid;
		}

		return (tree[i][l] <= K) ? 0 : tree[i].length - l;
	}

	private static void build(int l, int r, int i) {
		if (i >= H)
			return;
		int mid = (l + r) / 2;
		build(l, mid, i * 2);
		build(mid + 1, r, i * 2 + 1);

		tree[i] = new int[r - l + 1];
		int p = 0;
		int pl = 0;
		int pr = 0;
		int[] left = tree[i * 2];
		int[] right = tree[i * 2 + 1];

		while (pl < left.length && pr < right.length) {
			if (left[pl] < right[pr])
				tree[i][p++] = left[pl++];
			else
				tree[i][p++] = right[pr++];
		}
		while (pl < left.length)
			tree[i][p++] = left[pl++];
		while (pr < right.length)
			tree[i][p++] = right[pr++];
	}
}