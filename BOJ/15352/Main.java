/*
 * Author: Minho Kim (ISKU)
 * Date: December 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15352
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] fans, root, left, right, count;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		fans = new int[N + 1];
		root = new int[N + 1];
		left = new int[N + 1];
		right = new int[N + 1];
		count = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			root[i] = i;
			left[i] = i - 1;
			right[i] = i + 1;
			count[i] = 1;

			fans[i] = Integer.parseInt(st.nextToken());
			if (fans[i] == fans[i - 1])
				union(i, i - 1);
		}

		int Q = Integer.parseInt(br.readLine());
		long answer = 0;
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (cmd == 1)
				remove(v);
			if (cmd == 2)
				answer += count[find(v)];
		}

		System.out.print(answer);
	}

	private static void remove(int v) {
		int l = left[v];
		int r = right[v];

		count[find(v)]--;
		if (l > 0)
			right[l] = r;
		if (r <= N)
			left[r] = l;

		if (l > 0 && r <= N && fans[l] == fans[r])
			union(l, r);
	}

	private static int find(int v) {
		if (root[v] == v)
			return v;
		return root[v] = find(root[v]);
	}

	private static void union(int u, int v) {
		int first = find(u);
		int second = find(v);

		if (first != second) {
			root[second] = first;
			count[first] += count[second];
		}
	}
}