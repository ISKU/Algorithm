/*
 * Author: Minho Kim (ISKU)
 * Date: February 9, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2517
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree;
	private static int H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N + 1];
		for (int i = 1; i <= N; i++)
			array[i] = Integer.parseInt(br.readLine());

		int[] set = Arrays.copyOf(array, N + 1);
		Arrays.sort(set);

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new int[H * 2];

		for (int i = 1; i <= N; i++) {
			int R = Arrays.binarySearch(set, array[i]);
			int inversion = sum(1, H, 1, 1, R);
			update(R, 1);

			bw.write(String.valueOf(i - inversion));
			bw.write('\n');
		}

		bw.close();
	}

	private static int sum(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return 0;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return sum(l, mid, i * 2, L, R) + sum(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int i, int value) {
		i += H - 1;
		tree[i] = value;

		while (i > 0) {
			i /= 2;
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
}