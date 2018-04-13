/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11658
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[][] array, tree;
	private static int N;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new int[N + 1][N + 1];
		array = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				update(i, j, array[i][j]);
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			if (st.nextToken().equals("0")) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(x, y, value - array[x][y]);
				array[x][y] = value;
			} else {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				bw.write((sum(x2, y2) - sum(x1 - 1, y2) - sum(x2, y1 - 1) + sum(x1 - 1, y1 - 1)) + "\n");
			}
		}

		bw.close();
	}

	private static long sum(int x, int y) {
		int ret = 0;
		
		for (int i = x; i > 0; i -= i & -i)
			for (int j = y; j > 0; j -= j & -j)
				ret += tree[i][j];
		
		return ret;
	}

	private static void update(int x, int y, int diff) {
		for (int i = x; i <= N; i += i & -i)
			for (int j = y; j <= N; j += j & -j)
				tree[i][j] += diff;
	}
}