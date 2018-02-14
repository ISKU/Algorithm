/*
 * Author: Minho Kim (ISKU)
 * Date: February 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/934/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		long[] tommy = new long[N];
		long[] banban = new long[M];
		for (int i = 0; i < N; i++)
			tommy[i] = sc.nextLong();
		for (int j = 0; j < M; j++)
			banban[j] = sc.nextLong();

		long max = Long.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (max < tommy[i] * banban[j]) {
					max = tommy[i] * banban[j];
					index = i;
				}
			}
		}

		max = Long.MIN_VALUE;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (index != i)
					max = Math.max(max, tommy[i] * banban[j]);

		System.out.print(max);
	}
}