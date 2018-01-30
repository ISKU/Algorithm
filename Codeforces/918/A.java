/*
 * Author: Minho Kim (ISKU)
 * Date: January 29, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/918/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashSet<Integer> fibo = new HashSet<Integer>() {{
			add(1);
		}};

		int a = 1;
		int b = 1;
		for (int i = 0; i <= 1010; i++) {
			int c = a + b;
			fibo.add(c);
			a = b;
			b = c;
		}

		for (int i = 1; i <= N; i++)
			System.out.print((fibo.contains(i)) ? "O" : "o");
	}
}