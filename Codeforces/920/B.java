/*
 * Author: Minho Kim (ISKU)
 * Date: February 02, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/920/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		while (testCase-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				nodes[i] = new Node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(nodes);
			int[] answer = new int[N];
			int time = 1;
			for (int i = 0; i < N; i++) {
				if (nodes[i].start > time)
					time = nodes[i].start;
				if (nodes[i].start <= time && nodes[i].end - time >= 0) {
					answer[nodes[i].index] = time;
					time++;
				}
			}

			for (int i = 0; i < N; i++)
				bw.write(answer[i] + " ");
			bw.newLine();
		}

		bw.close();
	}

	private static class Node implements Comparable<Node> {
		public int index;
		public int start;
		public int end;

		public Node(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.start != o.start)
				return this.start - o.start;
			else
				return this.index - o.index;
		}
	}
}