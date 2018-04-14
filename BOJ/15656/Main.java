/*
 * Author: Minho Kim (ISKU)
 * Date: April 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15656
 */

import java.util.*;

public class Main {

	private static int[] array;
	private static int N, M;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		Arrays.sort(array);
		dfs(0, "");
	}

	private static void dfs(int s, String result) {
		if (s >= M) {
			System.out.println(result);
			return;
		}

		for (int i = 0; i < N; i++)
			dfs(s + 1, result + array[i] + " ");
	}
}