/*
 * Author: Minho Kim (ISKU)
 * Date: June 8, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17269
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[] letter = new int[]
		{ 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		char[] first = st.nextToken().toCharArray();
		char[] second = st.nextToken().toCharArray();
		int[][] table = new int[N + M - 1][N + M];
		int T = Math.min(N, M);
		int n = 0;
		int m = 0;
		for (; n < T; n++, m += 2) {
			table[0][m] = letter[first[n] - 'A'];
			table[0][m + 1] = letter[second[n] - 'A'];
		}
		for (; n < N; n++, m++)
			table[0][m] = letter[first[n] - 'A'];
		for (; n < M; n++, m++)
			table[0][m] = letter[second[n] - 'A'];

		for (int i = 1; i < N + M - 1; i++)
			for (int j = 0; j < N + M - i; j++)
				table[i][j] = (table[i - 1][j] + table[i - 1][j + 1]) % 10;

		if (table[N + M - 2][0] != 0)
			System.out.print(table[N + M - 2][0]);
		System.out.print(table[N + M - 2][1] + "%");
	}
}