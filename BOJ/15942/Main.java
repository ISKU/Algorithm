/*
 * Author: Minho Kim (ISKU)
 * Date: July 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15942
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int N;

	public static void main(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		int k = sc.nextInt();
		int p = sc.nextInt();

		if (p == 1 && k != 1)
			exit();
		if ((int) (Math.log(p) / Math.log(2)) >= k)
			exit();
		if (dfs(p) > N - k)
			exit();

		int[] tree = new int[N + 1];
		boolean[] set = new boolean[N + 1];

		for (int i = p, h = 0; i <= N; i *= 2, h++) {
			for (int j = i - 1 + (1 << h); j >= i; j--) {
				if (j <= N) {
					set[k] = true;
					tree[j] = k++;
				}
			}
		}
		for (int h = (int) (Math.log(p) / Math.log(2)); p >= 1;) {
			p /= 2;
			set[h] = true;
			tree[p] = h--;
		}
		for (int i = 1, n = 1; i <= N; i++) {
			if (tree[i] != 0)
				continue;
			while (set[n])
				n++;
			tree[i] = n++;
		}

		for (int i = 1; i <= N; i++)
			bw.write(tree[i] + "\n");
		bw.close();
	}

	private static int dfs(int v) {
		int count = 0;

		if (v * 2 <= N)
			count = dfs(v * 2) + 1;
		if (v * 2 + 1 <= N)
			count += dfs(v * 2 + 1) + 1;

		return count;
	}

	private static void exit() {
		System.out.print(-1);
		System.exit(0);
	}
}