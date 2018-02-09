/*
 * Author: Minho Kim (ISKU)
 * Date: February 08, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/922/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();

		if ((y == 0) || (x == 0 && y >= 2) || (x < y - 1) || (y == 1 && x >= 1)) {
			System.out.println("No");
		} else {
			if ((x % 2 == 1 && y % 2 == 0) || (x % 2 == 0 && y % 2 == 1))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}