/*
 * Author: Minho Kim (ISKU)
 * Date: May 1, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/975/C
 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] psum = new long[N];
		psum[0] = Long.parseLong(st.nextToken());
		for (int i = 1; i < N; i++)
			psum[i] = psum[i - 1] + Long.parseLong(st.nextToken());

		long prev = 0;
		st = new StringTokenizer(br.readLine());
		while (Q-- > 0) {
			long q = prev + Long.parseLong(st.nextToken());
			prev = q;

			if (q >= psum[N - 1]) {
				prev = 0;
				bw.write(N + "\n");
				continue;
			}

			int i = lowerBound(psum, N - 1, q);
			bw.write((N - i + (psum[i] == prev ? -1 : 0)) + "\n");
		}

		bw.close();
	}

	public static int lowerBound(long[] array, int size, long value) {
		int l = 0;
		int h = size;

		while (l < h) {
			int mid = (l + h) / 2;

			if (value <= array[mid])
				h = mid;
			else
				l = mid + 1;
		}

		return l;
	}
}