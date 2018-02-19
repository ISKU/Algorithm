/*
 * Author: Minho Kim (ISKU)
 * Date: February 20, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/935/B
 */

import java.util.*;

public class B {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String line = sc.next();

		int x = 0, y = 0;
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			char c = line.charAt(i);

			if (c == 'U')
				y++;
			if (c == 'R')
				x++;

			if (x == y) {
				if (c == 'U' && line.charAt(i + 1) == 'U')
					count++;
				if (c == 'R' && line.charAt(i + 1) == 'R')
					count++;
			}
		}

		System.out.print(count);
	}
}