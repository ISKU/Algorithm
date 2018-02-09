/*
 * Author: Minho Kim (ISKU)
 * Date: February 08, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/922/B
 */

import java.util.*;

public class B {

	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int count = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int k = i ^ j;

				if (i == 0 || j == 0 || k == 0 || i > N || j > N || k > N)
					continue;

				if (i <= k && j <= k && k < i + j)
					count++;
				else if (j <= i && k <= i && i < j + k)
					count++;
				else if (k <= j && i <= j && j < i + k)
					count++;
			}
		}

		System.out.print(count / 6);
	}
}