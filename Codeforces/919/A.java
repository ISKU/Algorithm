/*
 * Author: Minho Kim (ISKU)
 * Date: January 31, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/919/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double M = sc.nextDouble();

		double min = Double.MAX_VALUE;
		for (int i = 0; i < N; i++)
			min = Math.min(min, sc.nextDouble() / sc.nextDouble());

		System.out.printf("%.7f", min * M);
	}
}