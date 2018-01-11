/* 
 * Author: Minho Kim (ISKU)
 * Date: January 10, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1976
 */

import java.util.*;

public class Main {

	private static int[] parent;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				if (sc.nextInt() == 1 && find(i) != find(j))
					parent[find(i)] = parent[j];

		int root = find(sc.nextInt());
		boolean answer = true;
		while (M-- > 1)
			if (root != find(sc.nextInt()))
				answer = false;

		System.out.println(answer ? "YES" : "NO");
	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}
}