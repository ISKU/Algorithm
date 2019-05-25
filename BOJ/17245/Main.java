/*
 * Author: Minho Kim (ISKU)
 * Date: May 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17245
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int MAX = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] computer = new int[MAX + 1];
		long total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				computer[n]++;
				total += n;
			}
		}
		if (N * N == computer[0]) {
			System.out.print(0);
			System.exit(0);
		}

		long server = N * N - computer[0];
		long sum = 0;
		for (int i = 1; i <= MAX; i++) {
			sum += server;
			server -= computer[i];

			if (sum * 2 >= total) {
				System.out.print(i);
				break;
			}
		}
	}
}