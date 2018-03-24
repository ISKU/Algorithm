/*
 * Author: Minho Kim (ISKU)
 * Date: March 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14913
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int d = sc.nextInt();
		int an = sc.nextInt();

		int n = 0;
		for (int i = 1, num = a; Math.abs(num) < 1e6; i++, num += d)
			if (num == an)
				n = i;

		System.out.print((n == 0) ? "X" : n);
	}
}