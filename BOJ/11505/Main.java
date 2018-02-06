/*
 * Author: Minho Kim (ISKU)
 * Date: February 06, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11505
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final long MOD = 1000000007;
	private static long[] tree;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

		H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[H * 2];
		for (int i = 1; i <= N; i++)
			update(i, Long.parseLong(br.readLine()));

		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 1)
				update(a, b);
			if (command == 2) {
				bw.write(String.valueOf(mult(1, H, 1, a, b)));
				bw.newLine();
			}
		}

		bw.close();
	}

	private static long mult(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return 1;
		if (L <= l && r <= R)
			return tree[i] % MOD;

		int mid = (l + r) / 2;
		return mult(l, mid, i * 2, L, R) * mult(mid + 1, r, i * 2 + 1, L, R) % MOD;
	}

	private static void update(int i, long value) {
		i += H - 1;
		tree[i] = value;

		while (i > 1) {
			i /= 2;
			tree[i] = tree[i * 2] * tree[i * 2 + 1] % MOD;
		}
	}
}