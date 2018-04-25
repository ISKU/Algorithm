/*
 * Author: Minho Kim (ISKU)
 * Date: April 23, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15701
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		int count = 0;
		for (int i = 1; i * i <= N; i++)
			if (N % i == 0)
				count += 2;

		if ((int) Math.sqrt(N) * (int) Math.sqrt(N) == N)
			count--;
		System.out.print(count);
	}
}