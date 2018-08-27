/*
 * Author: Minho Kim (ISKU)
 * Date: August 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12101
 */

import java.util.*;

public class Main {

	private static ArrayList<String> candidate;
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();

		candidate = new ArrayList<String>();
		for (int i = 1; i <= 3; i++)
			dfs(i, String.valueOf(i));

		Collections.sort(candidate);
		System.out.println((candidate.size() < K) ? -1 : candidate.get(K - 1));
	}

	private static void dfs(int n, String formula) {
		if (n > N)
			return;
		if (n == N) {
			candidate.add(formula);
			return;
		}

		dfs(n + 1, formula + "+1");
		dfs(n + 2, formula + "+2");
		dfs(n + 3, formula + "+3");
	}
}