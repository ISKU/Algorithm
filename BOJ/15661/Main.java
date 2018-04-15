/*
 * Author: Minho Kim (ISKU)
 * Date: April 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15661
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

		System.out.print(dfs(0, ""));
	}

	private static int dfs(int idx, String team) {
		if (idx == N) {
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

		return Math.min(dfs(idx + 1, team + "1"), dfs(idx + 1, team + "0"));
	}
}