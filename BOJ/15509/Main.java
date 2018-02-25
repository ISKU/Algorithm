/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15509
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] parent;
	private static int[] roots;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			parent[find(Integer.parseInt(st.nextToken()))] = find(Integer.parseInt(st.nextToken()));
		}

		roots = new int[N + 1];
		for (int i = 1; i <= N; i++)
			roots[find(i)]++;

		int set = 0;
		for (int i = 1; i <= N; i++)
			if (roots[i] != 0)
				set++;

		System.out.print((set == 1) ? "DOOMED" : "SAFE");
	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}
}