/*
 * Author: Minho Kim (ISKU)
 * Date: March 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2623
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] in = new int[N + 1];
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int E = Integer.parseInt(st.nextToken()) - 1;
			int u = Integer.parseInt(st.nextToken());

			while (E-- > 0) {
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				in[v]++;
				u = v;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			if (in[i] == 0)
				q.add(i);

		ArrayList<Integer> answer = new ArrayList<>();
		while (!q.isEmpty()) {
			int u = q.poll();
			answer.add(u);

			for (int v : graph[u])
				if (--in[v] == 0)
					q.add(v);
		}

		if (answer.size() < N)
			bw.write("0");
		else {
			for (int i : answer)
				bw.write(i + "\n");
		}

		bw.close();
	}
}