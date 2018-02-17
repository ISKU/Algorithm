/*
 * Author: Minho Kim (ISKU)
 * Date: February 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/939/A
 */

import java.util.*;

public class A {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] graph = new int[N + 1];
		for (int i = 1; i < N + 1; i++)
			graph[i] = sc.nextInt();

		boolean cycle = false;
		for (int i = 1; i < N + 1; i++)
			if (i == graph[graph[graph[i]]])
				cycle = true;

		System.out.print(cycle ? "YES" : "NO");
	}
}