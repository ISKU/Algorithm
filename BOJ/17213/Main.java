/*
 * Author: Minho Kim (ISKU)
 * Date: May 20, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17213
 */

import java.io.*;

public class Main {

	private static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		dfs(1, M);
		System.out.print(answer);
	}

	private static void dfs(int n, int M) {
		if (n == N) {
			answer++;
			return;
		}

		for (int i = 1; i < M; i++)
			dfs(n + 1, M - i);
	}
}