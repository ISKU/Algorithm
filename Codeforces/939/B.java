/*
 * Author: Minho Kim (ISKU)
 * Date: February 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/939/B
 */

import java.util.*;
import java.io.*;

public class B {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] box = new long[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++)
			box[i] = Long.parseLong(st.nextToken());

		long max = 0;
		long count = 0;
		int index = 0;
		for (int i = 0; i < K; i++) {
			if (max < (N / box[i]) * box[i]) {
				max = (N / box[i]) * box[i];
				count = N / box[i];
				index = i;
			}
		}

		System.out.print((index + 1) + " " + count);
	}
}