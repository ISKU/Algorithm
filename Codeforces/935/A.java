/*
 * Author: Minho Kim (ISKU)
 * Date: February 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/935/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int count = 0;
		for (int i = 1; i < N; i++) {
			int temp = N - i;
			if (temp % i == 0)
				count++;
		}

		System.out.print(count);
	}
}