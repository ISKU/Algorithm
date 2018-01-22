/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1182
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		int max = (int) Math.pow(2, N);
		int count = 0;
		for (int i = 1; i < max; i++) {
			int sum = 0;
			for (int j = i, d = 0; j > 0; j >>>= 1, d++)
				if ((j & 1) == 1)
					sum += array[d];

			if (sum == S)
				count++;
		}

		System.out.print(count);
	}
}