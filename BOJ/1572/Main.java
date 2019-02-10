/*
 * Author: Minho Kim (ISKU)
 * Date: February 9, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1572
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int MAX = 65535;
	private static int[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		tree = new int[(MAX + 1) * 2];
		int[] array = new int[N];
		for (int i = 0; i < K; i++) {
			array[i] = Integer.parseInt(br.readLine());
			update(array[i], 1);
		}

		long sum = query(0, MAX, 1, (K + 1) / 2);
		for (int i = K; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
			update(array[i - K], -1);
			update(array[i], 1);
			sum += query(0, MAX, 1, (K + 1) / 2);
		}

		System.out.println(sum);
	}

	private static long query(int l, int r, int i, int K) {
		if (l == r)
			return l;
		int mid = (l + r) / 2;

		if (tree[i * 2] >= K)
			return query(l, mid, i * 2, K);
		else
			return query(mid + 1, r, i * 2 + 1, K - tree[i * 2]);
	}

	private static void update(int i, int value) {
		i += MAX + 1;
		tree[i] += value;

		while (i > 0) {
			i /= 2;
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}
}