/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15508
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] parent, count;
	private static ArrayList<Integer> roots;
	private static int K;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			parent[find(Integer.parseInt(st.nextToken()))] = find(Integer.parseInt(st.nextToken()));
		}

		count = new int[N + 1];
		for (int i = 1; i <= N; i++)
			count[find(i)]++;

		roots = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++)
			if (count[i] != 0)
				roots.add(count[i]);

		System.out.print((roots.size() == 1) ? "DOOMED" : dfs(0, 0) ? "SAFE" : "DOOMED");
	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}

	private static boolean dfs(int i, int value) {
		if (i == roots.size()) {
			if (value == K)
				return true;
			return false;
		}
		if (value == K)
			return true;

		return dfs(i + 1, value + roots.get(i)) | dfs(i + 1, value);
	}
}
