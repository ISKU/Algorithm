/*
 * Author: Minho Kim (ISKU)
 * Date: March 16, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17071
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int MAX = 500000;
	private static int N, K;
	private static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[2][MAX + 1];
		Arrays.fill(dist[0], -1);
		Arrays.fill(dist[1], -1);
		bfs();

		int count = 0;
		while (K <= 500000) {
			for (int b = 0; b < 2; b++)
				if (count >= dist[b][K] && Math.abs(count - dist[b][K]) % 2 == 0)
					exit(count);

			count++;
			K += count;
		}

		System.out.println(-1);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { N, 0 });
		dist[0][N] = 0;
		dist[1][N] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int count = cur[1] + 1;

			for (int b = 0; b < 2; b++) {
				for (int nx : new int[] { x - 1, x + 1, x * 2 }) {
					if (nx < 0 || nx > MAX || dist[b][nx] != -1 || count % 2 != b)
						continue;

					dist[b][nx] = count;
					q.add(new int[] { nx, count });
				}
			}
		}
	}

	private static void exit(int value) {
		System.out.println(value);
		System.exit(0);
	}
}