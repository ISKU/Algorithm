/*
 * Author: Minho Kim (ISKU)
 * Date: February 08, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/922/C
 */

import java.util.*;

public class C {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long k = sc.nextLong();

		HashSet<Long> set = new HashSet<Long>();
		for (int i = 1; i <= k; i++) {
			if (!set.contains(n % i))
				set.add(n % i);
			else {
				System.out.print("No");
				System.exit(0);
			}
		}

		System.out.print("Yes");
	}
}
