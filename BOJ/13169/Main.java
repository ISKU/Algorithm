/*
 * Author: Minho Kim (ISKU)
 * Date: March 3, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13169
 */

import java.util.*;

public class Main {

	private static long[] array;
	private static int N;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		array = new long[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		System.out.print(sum(0, 0));
	}

	private static long sum(int i, long value) {
		if (i == N)
			return value;
		return sum(i + 1, value + array[i]) ^ sum(i + 1, value);
	}
}