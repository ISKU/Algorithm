/*
 * Author: Minho Kim (ISKU)
 * Date: April 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15664
 */

import java.util.*;

public class Main {

	private static int N, M;
	private static int[] array;
	private static HashSet<String> set;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		Arrays.sort(array);
		set = new HashSet<String>();
		dfs(0, 0, "");
	}

	private static void dfs(int s, int n, String result) {
		if (s >= M) {
			if (set.contains(result))
				return;

			set.add(result);
			System.out.println(result);
			return;
		}

		for (int i = n; i < N; i++)
			dfs(s + 1, i + 1, result + array[i] + " ");
	}
}