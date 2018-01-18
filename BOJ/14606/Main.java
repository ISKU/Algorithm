/*
 * Author: Minho Kim (ISKU)
 * Date: January 18, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14606
 */

import java.util.*;

public class Main {

	private static int answer;

	public static void main(String... args) {
		div(new Scanner(System.in).nextInt());
		System.out.print(answer);
	}

	private static void div(int n) {
		if (n <= 1)
			return;

		int first = (n % 2 == 1) ? n / 2 + 1 : n / 2;
		int second = n / 2;
		answer += first * second;

		div(first);
		div(second);
	}
}