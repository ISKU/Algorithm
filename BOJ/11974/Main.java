/*
 * Author: Minho Kim (ISKU)
 * Date: February 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11974
 */

import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] cow = new long[N];
		for (int i = 0; i < N; i++)
			cow[i] = Long.parseLong(br.readLine());

		long[] psum = new long[N];
		psum[0] = cow[0];
		for (int i = 1; i < N; i++)
			psum[i] = psum[i - 1] + cow[i];

		for (int i = 0; i < N; i++)
			psum[i] %= 7;

		int answer = 0;
		for (int i = 0; i < 7; i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				if (psum[j] == i) {
					max = Math.max(max, j);
					min = Math.min(min, j);
				}
			}

			if (max != Integer.MIN_VALUE && min != Integer.MAX_VALUE)
				answer = Math.max(answer, max - min);
		}

		System.out.print(answer);
	}
}