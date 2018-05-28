/*
 * Author: Minho Kim (ISKU)
 * Date: May 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/981/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		String line = new Scanner(System.in).next();

		for (int i = line.length(); i >= 1; i--) {
			String sub = line.substring(0, i);

			if (!sub.equals(new StringBuilder(sub).reverse().toString())) {
				System.out.print(sub.length());
				System.exit(0);
			}
		}

		System.out.print(0);
	}
}