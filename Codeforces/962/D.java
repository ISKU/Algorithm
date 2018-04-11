/*
 * Author: Minho Kim (ISKU)
 * Date: April 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/962/D
 */

import java.util.*;
import java.io.*;

public class D {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.value < o2.value)
					return -1;
				else if (o1.value > o2.value)
					return 1;
				else
					return o1.index - o2.index;
			}
		});

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			pq.add(new Node(i, Integer.parseInt(st.nextToken())));

		ArrayList<Node> answer = new ArrayList<>();
		while (!pq.isEmpty()) {
			Node l = pq.poll();

			if (!pq.isEmpty() && pq.peek().value == l.value)
				pq.add(new Node(pq.poll().index, l.value * 2));
			else
				answer.add(l);
		}

		Collections.sort(answer, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.index - o2.index;
			}
		});

		bw.write(answer.size() + "\n");
		for (Node p : answer)
			bw.write(p.value + " ");
		bw.close();
	}

	private static class Node {
		public int index;
		public long value;

		public Node(int index, long value) {
			this.index = index;
			this.value = value;
		}
	}
}