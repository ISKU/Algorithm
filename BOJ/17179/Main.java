/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17179
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[] cut;
	private static int M, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		cut = new int[M];
		for (int i = 0; i < M; i++)
			cut[i] = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int Q = Integer.parseInt(br.readLine());

			int l = 1;
			int r = L;
			while (l + 1 < r) {
				int mid = (l + r) / 2;

				if (possible(Q, mid))
					l = mid;
				else
					r = mid;
			}

			bw.write(l + "\n");
		}

		bw.close();
	}

	private static boolean possible(int Q, int K) {
		int count = 0;
		int next = K;

		for (int i = 0; i < M; i++) {
			if (cut[i] < next || cut[i] + K > L)
				continue;

			count++;
			next = cut[i] + K;
		}

		return Q <= count;
	}
}