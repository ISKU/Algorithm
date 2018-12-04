/*
 * Author: Minho Kim (ISKU)
 * Date: December 2, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://codeforces.com/problemset/problem/1089/L
 */

import java.util.*;
import java.io.*;

public class L {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet<>();
		Idler[] idlers = new Idler[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int job = Integer.parseInt(st.nextToken());
			idlers[i] = new Idler(job, 0);
			set.add(job);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			idlers[i].cost = Long.parseLong(st.nextToken());

		List<Long>[] list = new ArrayList[K + 1];
		for (int i = 1; i <= K; i++)
			list[i] = new ArrayList<Long>();

		for (int i = 0; i < N; i++)
			list[idlers[i].job].add(idlers[i].cost);
		for (int i = 1; i <= K; i++)
			Collections.sort(list[i]);

		List<Long> candidate = new ArrayList<>();
		for (int i = 1; i <= K; i++) {
			if (list[i].size() <= 1)
				continue;
			for (int j = 0; j < list[i].size() - 1; j++)
				candidate.add(list[i].get(j));
		}

		Collections.sort(candidate);
		int count = K - set.size();
		long sum = 0;
		for (int i = 0; i < count; i++)
			sum += candidate.get(i);

		System.out.println(sum);
	}

	private static class Idler {
		public int job;
		public long cost;

		public Idler(int job, long cost) {
			this.job = job;
			this.cost = cost;
		}
	}
}