/*
 * Author: Minho Kim (ISKU)
 * Date: May 16, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15735
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong();

		long sum = (N * (N + 1) * (N + 2)) / 6;
		for (long i = N - 1; i >= 1; i -= 2)
			sum += (i * (i + 1)) / 2;

		System.out.print(sum);
	}
}