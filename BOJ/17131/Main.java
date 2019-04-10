/*
 * Author: Minho Kim (ISKU)
 * Date: April 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17131
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final long MOD = 1_000_000_007;
	public static final int MAX = 400002;
	private static List<Integer>[] star;
	private static long[] bit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		star = new ArrayList[MAX];
		for (int i = 0; i < MAX; i++)
			star[i] = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + 200001;
			int y = Integer.parseInt(st.nextToken()) + 200001;
			star[y].add(x);
		}

		long answer = 0;
		bit = new long[MAX];
		for (int y = MAX - 2; y >= 0; y--) {
			for (int x : star[y + 1])
				update(x);
			for (int x : star[y])
				answer = (answer + ((sum(x - 1) * (sum(MAX - 1) - sum(x))) % MOD)) % MOD;
		}

		System.out.println(answer);
	}

	private static long sum(int x) {
		long sum = 0;
		for (int i = x; i > 0; i -= i & -i)
			sum += bit[i];

		return sum;
	}

	private static void update(int x) {
		for (int i = x; i < MAX; i += i & -i)
			bit[i] += 1;
	}

	private static class Star {
		public int y, x;

		public Star(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}