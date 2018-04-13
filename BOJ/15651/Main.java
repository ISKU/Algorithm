/*
 * Author: Minho Kim (ISKU)
 * Date: April 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15651
 */

import java.util.*;

public class Main {

	private static int N, M;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		dfs(0, "");
	}

	private static void dfs(int step, String result) {
		if (step >= M) {
			System.out.println(result);
			return;
		}

		for (int i = 1; i <= N; i++)
			dfs(step + 1, result + i + " ");
	}
}