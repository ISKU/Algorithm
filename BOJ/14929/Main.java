/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14929
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] array = new int[N + 1];
		int[] partial = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = sc.nextInt();
			partial[i] = partial[i - 1] + array[i];
		}

		long sum = 0;
		for (int i = 1; i <= N; i++)
			sum += array[i] * (partial[N] - partial[i]);

		System.out.print(sum);
	}
}