
/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15508
 */

import java.util.*;

public class Main {

	private static int[] parent;
	private static int[] roots;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		while (M-- > 0)
			parent[find(sc.nextInt())] = find(sc.nextInt());

		roots = new int[N + 1];
		for (int i = 1; i <= N; i++)
			roots[find(i)]++;

		int set = 0;
		for (int i = 1; i <= N; i++)
			if (roots[i] != 0)
				set++;

		System.out.print((set == 1) ? "DOOMED" : "SAFE");
	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}
}