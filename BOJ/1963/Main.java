/*
 * Author: Minho Kim (ISKU)
 * Date: August 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1963
 */

import java.util.*;
import java.io.*;

public class Main {

	private static boolean[] prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		prime = new boolean[10000];
		for (int i = 2; i * i < 10000; i++)
			if (!prime[i])
				for (int j = i * i; j < 10000; j += i)
					prime[j] = true;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int count = bfs(A, B);
			bw.write(((count == -1) ? "Impossible" : count) + "\n");
		}

		bw.close();
	}

	private static int bfs(int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[10000];

		q.add(A);
		visited[A] = 0;
		while (!q.isEmpty()) {
			int C = q.poll();
			if (C == B)
				return visited[C];

			int next = C;
			int[] digit = new int[4];
			for (int i = 0; i < 4; i++) {
				digit[i] = next % 10;
				next /= 10;
			}

			for (int i = 0, d = 1; i < 4; i++, d *= 10) {
				for (int j = 0; j <= 9; j++) {
					next = C - (d * digit[i]) + (d * j);
					if (next < 1000 || prime[next] || next == C || visited[next] != 0)
						continue;

					q.add(next);
					visited[next] = visited[C] + 1;
				}
			}
		}

		return -1;
	}
}