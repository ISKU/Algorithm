/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17128
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[] cows, table;
	private static int N, Q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		cows = new int[N];
		for (int i = 0; i < N; i++)
			cows[i] = Integer.parseInt(st.nextToken());

		table = new int[N];
		Arrays.fill(table, 1);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++)
				table[i] *= cows[(i + j) % N];
			sum += table[i];
		}

		st = new StringTokenizer(br.readLine());
		while (Q-- > 0) {
			int i = Integer.parseInt(st.nextToken()) - 4;
			if (i < 0)
				i = N + i;

			for (int j = 0; j < 4; j++) {
				int idx = (i + j) % N;
				table[idx] = -table[idx];
				sum += table[idx] * 2;
			}

			bw.write(sum + "\n");
		}

		bw.close();
	}
}