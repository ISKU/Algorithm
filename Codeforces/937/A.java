/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/937/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++)
			set.add(sc.nextInt());

		if (set.contains(0))
			System.out.print(set.size() - 1);
		else
			System.out.print(set.size());
	}
}