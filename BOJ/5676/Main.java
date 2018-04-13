/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5676
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] tree;
	private static int H;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			H = 1 << (int) Math.ceil(Math.log(N) / Math.log(2));
			tree = new int[H * 2];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				update(i, Integer.parseInt(st.nextToken()));

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if ("C".equals(command))
					update(a, b);
				else {
					int result = mult(1, H, 1, a, b);
					bw.write((result > 0) ? "+" : (result < 0) ? "-" : "0");
				}
			}

			bw.newLine();
		}

		bw.close();
	}

	private static int mult(int l, int r, int i, int L, int R) {
		if (r < L || R < l)
			return 1;
		if (L <= l && r <= R)
			return tree[i];

		int mid = (l + r) / 2;
		return mult(l, mid, i * 2, L, R) * mult(mid + 1, r, i * 2 + 1, L, R);
	}

	private static void update(int i, int value) {
		i += H - 1;
		tree[i] = (value > 0) ? 1 : (value < 0) ? -1 : 0;

		while (i > 0) {
			i /= 2;
			tree[i] = tree[i * 2] * tree[i * 2 + 1];
		}
	}
}