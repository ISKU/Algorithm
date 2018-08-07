/*
 * Author: Minho Kim (ISKU)
 * Date: August 7, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1747
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		boolean[] prime = sieve(1003002);

		for (int i = N; i < 1003002; i++) {
			if (prime[i])
				continue;
			if (isPalindrom(i)) {
				System.out.print(i);
				break;
			}
		}
	}

	private static boolean isPalindrom(int N) {
		int n = N;
		int k = 0;

		while (n > 0) {
			k *= 10;
			k += n % 10;
			n /= 10;
		}

		return (k == N);
	}

	private static boolean[] sieve(int N) {
		boolean[] prime = new boolean[N];
		prime[0] = prime[1] = true;

		for (int i = 1; i * i < N; i++)
			if (!prime[i])
				for (int j = i * i; j < N; j += i)
					prime[j] = true;

		return prime;
	}
}