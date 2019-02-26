/*
 * Author: Minho Kim (ISKU)
 * Date: February 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16975
 */

import java.io.*;
import java.util.*;

public class Main {

	private static long[] bit;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		bit = new long[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			long a = Long.parseLong(st.nextToken());
			update(i, a);
			update(i + 1, -a);
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				long k = Long.parseLong(st.nextToken());
				update(i, k);
				update(j + 1, -k);
			}
			if (cmd == 2) {
				int i = Integer.parseInt(st.nextToken());
				bw.write(String.valueOf(sum(i)));
				bw.write('\n');
			}
		}

		bw.close();
	}

	private static long sum(int x) {
		long sum = 0;
		for (int i = x; i > 0; i -= i & -i)
			sum += bit[i];
		return sum;
	}

	private static void update(int x, long value) {
		for (int i = x; i <= N; i += i & -i)
			bit[i] += value;
	}
}