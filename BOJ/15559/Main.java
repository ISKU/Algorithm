/*
 * Author: Minho Kim (ISKU)
 * Date: March 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15559
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] parent;
	private static int Y, X;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		parent = new int[Y * X];
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		for (int y = 0; y < Y; y++) {
			String line = br.readLine();

			for (int x = 0; x < X; x++) {
				int first = find(y * X + x);
				int second = find(edge(y, x, line.charAt(x)));

				if (first != second)
					parent[second] = first;
			}
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < parent.length; i++)
			set.add(find(i));

		System.out.print(set.size());
	}

	private static int edge(int y, int x, char c) {
		switch (c) {
		case 'N':
			if (y - 1 < 0)
				return y * X + x;
			return (y - 1) * X + x;
		case 'S':
			if (y + 1 >= Y)
				return y * X + x;
			return (y + 1) * X + x;
		case 'W':
			if (x - 1 < 0)
				return y * X + x;
			return y * X + (x - 1);
		case 'E':
			if (x + 1 >= X)
				return y * X + x;
			return y * X + (x + 1);
		default:
			return 0;
		}
	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}
}