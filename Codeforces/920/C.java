/*
 * Author: Minho Kim (ISKU)
 * Date: February 02, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/920/C
 */

import java.util.*;
import java.io.*;

public class C {

	private static int[] array;
	private static String swap;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		array = new int[N + 1];
		for (int i = 1; i <= N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		HashSet<Integer>[] set = new HashSet[N + 1];
		swap = br.readLine();
		for (int i = 0; i < N - 1; i++) {
			if (swap.charAt(i) == '1') {
				HashSet<Integer> temp = new HashSet<Integer>();
				int count = dfs(i + 1, 1, temp);

				for (int j = i + 1, cnt = 0; cnt <= count; j++, cnt++)
					set[j] = temp;
				i += count - 1;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (array[i] == i)
				continue;
			if (set[i] == null || !set[i].contains(i)) {
				System.out.print("NO");
				System.exit(0);
			}
		}

		System.out.print("YES");
	}

	private static int dfs(int i, int count, HashSet<Integer> set) {
		set.add(array[i]);

		if (i < N - 1 && swap.charAt(i) == '1')
			return dfs(i + 1, count + 1, set);
		else {
			set.add(array[i + 1]);
			return count;
		}
	}
}