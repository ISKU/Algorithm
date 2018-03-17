/*
 * Author: Minho Kim (ISKU)
 * Date: March 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1644
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		boolean[] sieve = new boolean[N + 1];
		for (int i = 2; i * i <= N; i++)
			if (!sieve[i])
				for (int j = i * i; j <= N; j += i)
					sieve[j] = true;

		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = 2; i <= N; i++)
			if (!sieve[i])
				prime.add(i);
		Collections.sort(prime);

		int count = 0;
		int i = 0, j = 0, sum = 0;
		while (true) {
			if (sum >= N)
				sum -= prime.get(i++);
			else if (j == prime.size())
				break;
			else
				sum += prime.get(j++);

			if (sum == N)
				count++;
		}

		System.out.print(count);
	}
}