/*
 * Author: Minho Kim (ISKU)
 * Date: March 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14889
 */

import java.util.*;

public class Main {

	private static int[][] table;
	private static int N;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		table = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				table[i][j] = sc.nextInt();

		System.out.print(dfs(0, 0, ""));
	}

	private static int dfs(int idx, int p, String team) {
		if (idx == N) {
			if (p < N / 2)
				return Integer.MAX_VALUE;

			int start = 0, link = 0;
			for (int i = 0; i < team.length(); i++) {
				for (int j = 0; j < team.length(); j++) {
					if (team.charAt(i) == '1')
						start += (team.charAt(j) == '1') ? table[i][j] : 0;
					else
						link += (team.charAt(j) == '0') ? table[i][j] : 0;
				}
			}

			return Math.abs(start - link);
		}
		if (p == N / 2)
			return dfs(idx + 1, p, team + "0");

		return Math.min(dfs(idx + 1, p + 1, team + "1"), dfs(idx + 1, p, team + "0"));
	}
}