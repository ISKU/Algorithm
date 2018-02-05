/*
 * Author: Minho Kim (ISKU)
 * Date: February 05, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13225
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();

		int[] divisors = new int[10001];
		for (int i = 1; i <= 10000; i++)
			for (int j = i; j <= 10000; j += i)
				divisors[j]++;

		while (C-- > 0) {
			int n = sc.nextInt();
			System.out.printf("%d %d\n", n, divisors[n]);
		}
	}
}