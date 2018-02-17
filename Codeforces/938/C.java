/*
 * Author: Minho Kim (ISKU)
 * Date: February 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/938/C
 */

import java.util.*;

public class C {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			long x = sc.nextLong();

			if (x == 0) {
				System.out.println("1 1");
				continue;
			}

			boolean find = false;
			int limit = (int) Math.sqrt(4 * x / 3);
			for (int n = (int) Math.sqrt(x); n <= limit; n++) {
				long nx = n * n - x;
				if (nx == 0)
					continue;

				int m = (int) Math.sqrt((n * n) / nx);
				if (m == 0)
					continue;

				if ((n * n) - ((n / m) * (n / m)) == x) {
					System.out.printf("%d %d\n", n, m);
					find = true;
					break;
				}
			}

			if (!find)
				System.out.println(-1);
		}
	}
}