/*
 * Author: Minho Kim (ISKU)
 * Date: March 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9020
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		boolean[] prime = new boolean[10001];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= 1e4; i++)
			if (!prime[i])
				for (int j = i * i; j <= 1e4; j += i)
					prime[j] = true;

		while (T-- > 0) {
			int N = sc.nextInt();

			for (int i = N / 2; i <= N; i++) {
				if (!prime[N - i] && !prime[i]) {
					System.out.printf("%d %d\n", N - i, i);
					break;
				}
			}
		}
	}
}