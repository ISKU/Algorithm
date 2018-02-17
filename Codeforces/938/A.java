/*
 * Author: Minho Kim (ISKU)
 * Date: February 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/938/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder word = new StringBuilder(sc.next());

		char prev = word.charAt(0);
		for (int i = 1; i < N; i++) {
			if (isVowel(word.charAt(i)) && isVowel(prev)) {
				word.replace(i, i + 1, " ");
				continue;
			}
			prev = word.charAt(i);
		}

		System.out.print(word.toString().replaceAll(" ", ""));
	}

	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y');
	}
}