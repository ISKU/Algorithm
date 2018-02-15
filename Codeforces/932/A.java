/*
 * Author: Minho Kim (ISKU)
 * Date: February 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/932/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		String line = new Scanner(System.in).next();
		System.out.print(line + new StringBuilder(line).reverse());
	}
}