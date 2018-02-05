/*
 * Author: Minho Kim (ISKU)
 * Date: February 05, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13226
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();

		int[] divisors = new int[10000001];
		for (int i = 1; i <= 10000000; i++)
			for (int j = i; j <= 10000000; j += i)
				divisors[j]++;

		while (C-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			int max = 0;
			for (int i = start; i <= end; i++)
				max = Math.max(max, divisors[i]);

			System.out.println(max);
		}
	}
}