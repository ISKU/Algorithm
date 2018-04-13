/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15652
 */

import java.util.*;

public class Main {

	private static int N, M;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		dfs(0, 1, "");
	}

	private static void dfs(int step, int n, String result) {
		if (step >= M) {
			System.out.println(result);
			return;
		}

		for (int i = n; i <= N; i++)
			dfs(step + 1, i, result + i + " ");
	}
}