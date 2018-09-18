/*
 * Author: Minho Kim (ISKU)
 * Date: September 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8217
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] pbs, biu;
	private static long[] tree;
	private static int[] aim, l, r;
	private static Meteor[] meteors;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		biu = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			biu[i] = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++)
			biu[Integer.parseInt(st.nextToken())].add(i);

		st = new StringTokenizer(br.readLine());
		aim = new int[N + 1];
		for (int i = 1; i <= N; i++)
			aim[i] = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());
		meteors = new Meteor[K + 1];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long count = Long.parseLong(st.nextToken());
			meteors[i] = new Meteor(l, r, count);
		}

		pbs = new ArrayList[K + 1];
		l = new int[N + 1];
		r = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			l[i] = 1;
			r[i] = K + 1;
		}

		boolean finish = true;
		while (finish) {
			finish = false;
			tree = new long[M + 1];
			for (int i = 1; i <= K; i++)
				pbs[i] = new ArrayList<Integer>();

			for (int i = 1; i <= N; i++)
				if (l[i] < r[i])
					pbs[(l[i] + r[i]) / 2].add(i);

			for (int i = 1; i <= K; i++) {
				if (meteors[i].l <= meteors[i].r) {
					update(meteors[i].l, meteors[i].count);
					update(meteors[i].r + 1, -meteors[i].count);
				} else {
					update(1, meteors[i].count);
					update(meteors[i].r + 1, -meteors[i].count);
					update(meteors[i].l, meteors[i].count);
				}

				for (int j = 0; j < pbs[i].size(); j++) {
					finish = true;
					int index = pbs[i].get(j);

					long sum = 0;
					for (int idx : biu[index]) {
						sum += sum(idx);
						if (sum >= aim[index])
							break;
					}

					if (sum < aim[index])
						l[index] = i + 1;
					else
						r[index] = i;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (l[i] == K + 1)
				bw.write("NIE\n");
			else {
				bw.write(String.valueOf(l[i]));
				bw.write("\n");
			}
		}
		bw.close();
	}

	private static void update(int x, long value) {
		for (int i = x; i <= M; i += i & -i)
			tree[i] += value;
	}

	private static long sum(int x) {
		long ret = 0;
		for (int i = x; i > 0; i -= i & -i)
			ret += tree[i];
		return ret;
	}

	private static class Meteor {
		public int l, r;
		public long count;

		public Meteor(int l, int r, long count) {
			this.l = l;
			this.r = r;
			this.count = count;
		}
	}
}