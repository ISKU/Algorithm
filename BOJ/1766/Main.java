/*
 * Author: Minho Kim (ISKU)
 * Date: February 05, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1766
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static int[] in;
	private static int V, E;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		in = new int[V + 1];
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<Integer>();

		while (E-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			graph[first].add(second);
			in[second]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 1; i <= V; i++)
			if (in[i] == 0)
				pq.add(i);

		while (!pq.isEmpty()) {
			int vertex = pq.poll();
			System.out.printf("%d ", vertex);

			for (int to : graph[vertex])
				if (--in[to] == 0)
					pq.add(to);
		}
	}
}