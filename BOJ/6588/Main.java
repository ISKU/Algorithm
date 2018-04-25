/*
 * Author: Minho Kim (ISKU)
 * Date: April 24, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6588
 */

import java.io.*;

public class Main {
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= 1000000; i++)
			if (!prime[i])
				for (int j = i * i; j <= 1000000; j += i)
					prime[j] = true;

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			for (int i = 3; i <= N; i++) {
				if (!prime[i] && !prime[N - i]) {
					bw.write(String.format("%d = %d + %d\n", N, i, N - i));
					break;
				}
			}
		}

		bw.close();
	}
}