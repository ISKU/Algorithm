/*
 * Author: Minho Kim (ISKU)
 * Date: December 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14846
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[][][] psum = new int[N + 1][N + 1][11];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				for (int i = 1; i <= 10; i++)
					psum[r][c][i] = psum[r - 1][c][i] + psum[r][c - 1][i] - psum[r - 1][c - 1][i];
				psum[r][c][Integer.parseInt(st.nextToken())]++;
			}
		}

		int Q = Integer.parseInt(br.readLine());
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			int count = 0;
			for (int i = 1; i <= 10; i++)
				if (psum[r2][c2][i] - psum[r1 - 1][c2][i] - psum[r2][c1 - 1][i] + psum[r1 - 1][c1 - 1][i] > 0)
					count++;

			bw.write(String.valueOf(count));
			bw.write('\n');
		}

		bw.close();
	}
}