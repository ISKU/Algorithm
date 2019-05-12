/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17073
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		double W = Double.parseDouble(st.nextToken());

		List<Integer>[] tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		int leaf = 0;
		for (int u = 2; u <= N; u++)
			if (tree[u].size() == 1)
				leaf++;

		System.out.printf("%.5f", W / leaf);
	}
}