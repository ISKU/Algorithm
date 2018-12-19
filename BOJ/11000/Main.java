/*
 * Author: Minho Kim (ISKU)
 * Date: December 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11000
 */

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Data[] datas = new Data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			datas[i] = new Data(s, e);
		}
		Arrays.sort(datas, new Comparator<Data>() {
			@Override
			public int compare(Data o1, Data o2) {
				if (o1.s == o2.s)
					return Integer.compare(o1.e, o2.e);
				return Integer.compare(o1.s, o2.s);
			}
		});

		Queue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			if (!pq.isEmpty() && pq.peek() <= datas[i].s)
				pq.poll();
			pq.add(datas[i].e);
		}

		System.out.print(pq.size());
	}

	private static class Data {
		public int s, e;

		public Data(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
