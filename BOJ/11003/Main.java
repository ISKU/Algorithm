/*
 * Author: Minho Kim (ISKU)
 * Date: April 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11003
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];
		st = new StringTokenizer(br.readLine());
		for (int i = H; i < H + N; i++)
			tree[i] = Integer.parseInt(st.nextToken());
		for (int i = H - 1; i >= 0; i--)
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);

		for (int i = 1; i <= N; i++) {
			int start = i - L + 1;
			bw.write(min(1, H, 1, (start <= 0) ? 1 : start, i) + " ");
		}

		bw.close();
	}

	private static int min(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return Integer.MAX_VALUE;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return Math.min(min(l, mid, i * 2, L, R), min(mid + 1, r, i * 2 + 1, L, R));
	}
}