/*
 * Author: Minho Kim (ISKU)
 * Date: May 26, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17250
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[] planet, root;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		planet = new int[N + 1];
		for (int i = 1; i <= N; i++)
			planet[i] = Integer.parseInt(br.readLine());

		root = new int[N + 1];
		for (int i = 1; i <= N; i++)
			root[i] = i;

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			int first = find(u);
			int second = find(v);
			if (first == second) {
				bw.write(planet[first] + "\n");
				continue;
			}

			root[second] = first;
			planet[first] += planet[second];
			bw.write(planet[first] + "\n");
		}

		bw.close();
	}

	private static int find(int v) {
		if (root[v] == v)
			return v;
		return root[v] = find(root[v]);
	}
}