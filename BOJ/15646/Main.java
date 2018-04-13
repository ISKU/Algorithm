/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15646
 */

import java.util.*;
import java.io.*;

public class Main {

	private static long[][] tree;
	private static int N, M;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		tree = new long[N + 2][M + 2];
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());

			if ("1".equals(st.nextToken())) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken()) + 1;
				int y2 = Integer.parseInt(st.nextToken()) + 1;
				long d = Long.parseLong(st.nextToken());
				update(x1, y1, d);
				update(x2, y2, d);
				update(x1, y2, -d);
				update(x2, y1, -d);
			} else {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				bw.write(sum(x, y) + "\n");
			}
		}

		bw.close();
	}

	private static long sum(int x, int y) {
		long ret = 0;

		for (int i = x; i > 0; i -= i & -i)
			for (int j = y; j > 0; j -= j & -j)
				ret += tree[i][j];

		return ret;
	}

	private static void update(int x, int y, long d) {
		for (int i = x; i <= N; i += i & -i)
			for (int j = y; j <= M; j += j & -j)
				tree[i][j] += d;
	}
}