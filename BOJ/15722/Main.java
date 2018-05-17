/*
 * Author: Minho Kim (ISKU)
 * Date: May 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15722
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int x = 0;
		int y = 0;
		int n = 0;
		int cell = 1;
		boolean dir = true;

		while (true) {
			if (n == N)
				finish(x, y);

			for (int i = 1; i <= cell; i++) {
				y = dir ? y + 1 : y - 1;
				if (++n == N)
					finish(x, y);
			}
			for (int i = 1; i <= cell; i++) {
				x = dir ? x + 1 : x - 1;
				if (++n == N)
					finish(x, y);
			}

			dir = !dir;
			cell++;
		}
	}

	private static void finish(int x, int y) {
		System.out.printf("%d %d", x, y);
		System.exit(0);
	}
}