/*
 * Author: Minho Kim (ISKU)
 * Date: March 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15624
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		if (N == 0)
			System.out.print(0);
		else if (N == 1)
			System.out.print(1);
		else {
			int a = 0;
			int b = 1;

			int n = 0;
			for (int i = 2; i <= N; i++) {
				n = (a + b) % 1000000007;
				a = b;
				b = n;
			}

			System.out.print(n);
		}
	}
}