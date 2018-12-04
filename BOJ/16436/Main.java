/*
 * Author: Minho Kim (ISKU)
 * Date: December 5, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16436
 */

import java.util.*;
import java.io.*;

public class Main {

	private static final int M = 2501;
	private static int[][] first, second;
	private static int Y, X;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		first = new int[Y + 2][X + 2];
		second = new int[Math.max(X, Y) + 2 + M][Math.max(X, Y) + 2 + M];

		int K = Integer.parseInt(st.nextToken());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int x1 = Integer.parseInt(st.nextToken()) + 1;
				int y1 = Integer.parseInt(st.nextToken()) + 1;
				int x2 = Integer.parseInt(st.nextToken()) + 2;
				int y2 = Integer.parseInt(st.nextToken()) + 2;
				update(y1, x1, y2, x2, first);
			}
			else if (cmd == 2) {
				int x = Integer.parseInt(st.nextToken()) + 1;
				int y = Integer.parseInt(st.nextToken()) + 1;
				int r = Integer.parseInt(st.nextToken());
				int x1 = (y - r) - x + M;
				int y1 = (y - r) + x;
				int x2 = (y + r) - x + M + 1;
				int y2 = (y + r) + x + 1;
				update(y1, x1, y2, x2, second);
			}
		}

		for (int y = 1; y <= Y; y++) {
			for (int x = 1; x <= X; x++) {
				int sum = sum(y, x, first) + sum(y + x, y - x + M, second);
				bw.write((sum % 2 == 1) ? '#' : '.');
			}
			bw.write('\n');
		}
		bw.close();
	}

	private static void update(int y1, int x1, int y2, int x2, int[][] bit) {
		update(y1, x1, 1, bit);
		update(y2, x2, 1, bit);
		update(y1, x2, -1, bit);
		update(y2, x1, -1, bit);
	}

	private static void update(int y, int x, int d, int[][] bit) {
		for (int i = y; i < bit.length; i += i & -i)
			for (int j = x; j < bit[i].length; j += j & -j)
				bit[i][j] += d;
	}

	private static int sum(int y, int x, int[][] bit) {
		int ret = 0;

		for (int i = y; i > 0; i -= i & -i)
			for (int j = x; j > 0; j -= j & -j)
				ret += bit[i][j];

		return ret;
	}
}