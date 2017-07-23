/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.24
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11438
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static int[][] parent;
	private static int[] depth;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(parser.nextToken()) + 1;
		int H = (int) (Math.log(N) / Math.log(2)) + 2;

		graph = new ArrayList<ArrayList<Integer>>();
		parent = new int[N][H];
		depth = new int[N];
		for (int i = 0; i < N; i++)
			graph.add(new ArrayList<Integer>());
		for (int i = 0; i < N; i++)
			Arrays.fill(parent[i], -1);
		Arrays.fill(depth, -1);
		depth[1] = 0;

		for (int i = 2; i < N; i++) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());
			graph.get(first).add(second);
			graph.get(second).add(first);
		}

		buildTree(1);

		for (int h = 0; h < H; h++)
			for (int i = 2; i < N; i++)
				if (parent[i][h] != -1)
					parent[i][h + 1] = parent[parent[i][h]][h];

		int M = Integer.parseInt(input.readLine());
		while (M-- > 0) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());

			if (depth[first] < depth[second]) {
				int temp = first;
				first = second;
				second = temp;
			}

			int diff = depth[first] - depth[second];
			for (int h = 0; diff != 0; h++) {
				if (diff % 2 != 0)
					first = parent[first][h];
				diff /= 2;
			}

			if (first != second) {
				for (int h = H - 1; h >= 0; h--)
					if (parent[first][h] != -1 && parent[first][h] != parent[second][h]) {
						first = parent[first][h];
						second = parent[second][h];
					}

				first = parent[first][0];
			}

			output.write(String.format("%d\n", first));
		}

		output.close();
	}

	private static void buildTree(int source) {
		for (int sink : graph.get(source))
			if (depth[sink] == -1) {
				parent[sink][0] = source;
				depth[sink] = depth[source] + 1;
				buildTree(sink);
			}
	}
}