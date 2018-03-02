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

	private static int[] parent, count;
	private static int[][] dp;
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

		dp = new int[roots.size()][1001];
		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], -1);
		System.out.print((roots.size() == 1) ? "DOOMED" : (dfs(0, 0) == 1) ? "SAFE" : "DOOMED");
	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}

	private static int dfs(int i, int value) {
		if (value == K)
			return 1;
		if (value > K)
			return 0;
		if (i == roots.size())
			return 0;
		if (dp[i][value] != -1)
			return dp[i][value];

		dp[i][value] = dfs(i + 1, value + roots.get(i)) | dfs(i + 1, value);
		return dp[i][value];
	}
}
