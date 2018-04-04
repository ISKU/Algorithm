/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3653
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree, index;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			H = 1 << (int) Math.ceil(Math.log(N + M) / Math.log(2));
			tree = new int[H * 2];
			index = new int[N + M + 1];
			for (int i = 1; i <= N; i++) {
				update(i, 1);
				index[N - i + 1] = i;
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				int q = Integer.parseInt(st.nextToken());
				bw.write(sum(1, H, 1, index[q] + 1, H) + " ");
				update(index[q], 0);
				update(N + i, 1);
				index[q] = N + i;
			}
			bw.newLine();
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