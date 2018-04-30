/*
 * Author: Minho Kim (ISKU)
 * Date: April 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15668
 */

import java.util.*;

public class Main {

	private static int N, LENGTH;
	private static boolean[] visited;

	public static void main(String... args) {
		N = new Scanner(System.in).nextInt();
		LENGTH = String.valueOf(N).length();

		visited = new boolean[10];
		dfs(1, 1, 0, 1, 0);

		System.out.print(-1);
	}

	private static void dfs(int n, long dA, long A, long dB, long B) {
		if (A + B == N && A != 0 && B != 0) {
			System.out.printf("%d + %d", A, B);
			System.exit(0);
		}
		if (n > LENGTH * 2)
			return;

		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (n <= LENGTH)
					dfs(n + 1, dA * 10, i * dA + A, dB, B);
				else
					dfs(n + 1, dA, A, dB * 10, i * dB + B);
				visited[i] = false;
			}
		}
	}
}