/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2004
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.print(Math.min(two(n) - two(m) - two(n - m), five(n) - five(m) - five(n - m)));
	}

	private static int two(int n) {
		int count = 0;
		for (long i = 2; i <= n; i *= 2)
			count += n / i;
		return count;
	}

	private static int five(int n) {
		int count = 0;
		for (long i = 5; i <= n; i *= 5)
			count += n / i;
		return count;
	}
}