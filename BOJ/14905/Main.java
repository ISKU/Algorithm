/*
 * Author: Minho Kim (ISKU)
 * Date: March 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14905
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		boolean[] prime = new boolean[(int) 1e8 + 1];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= 1e8; i++)
			if (!prime[i])
				for (int j = i * i; j <= 1e8; j += i)
					prime[j] = true;

		while (sc.hasNextInt()) {
			int N = sc.nextInt();

			if (N < 8)
				System.out.println("Impossible.");
			else {
				System.out.print((N % 2 == 0) ? "2 2 " : "2 3 ");
				N -= 4 + N % 2;

				for (int i = 2; i <= N; i++)
					if (!prime[i] && !prime[N - i]) {
						System.out.printf("%d %d\n", i, N - i);
						break;
					}
			}
		}
	}
}