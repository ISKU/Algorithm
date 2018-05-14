/*
 * Author: Minho Kim (ISKU)
 * Date: May 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/978/C
 */

import java.util.*;
import java.io.*;

public class C {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		long[] psum = new long[N + 1];
		psum[1] = Long.parseLong(st.nextToken());
		for (int i = 2; i <= N; i++)
			psum[i] = psum[i - 1] + Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; M > 0; M--) {
			long room = Long.parseLong(st.nextToken());

			while (psum[i] < room)
				i++;

			bw.write(String.format("%d %d\n", i, room - psum[i - 1]));
		}

		bw.close();
	}
}