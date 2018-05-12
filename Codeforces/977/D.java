/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/977/D
 */

import java.util.*;
import java.io.*;

public class D {

	private static int N;
	private static HashSet<Long> set;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new HashSet<Long>();
		for (int i = 0; i < N; i++)
			set.add(Long.parseLong(st.nextToken()));

		for (long l : set)
			dfs(1, l, new LinkedList<Long>());
	}

	private static void dfs(int n, long value, LinkedList<Long> list) {
		list.add(value);

		if (n == N) {
			for (Long l : list)
				System.out.printf("%d ", l);
			System.exit(0);
		}

		if (set.contains(value * 2)) {
			dfs(n + 1, value * 2, list);
			list.removeLast();
		}
		if (value % 3 == 0 && set.contains(value / 3)) {
			dfs(n + 1, value / 3, list);
			list.removeLast();
		}
	}
}