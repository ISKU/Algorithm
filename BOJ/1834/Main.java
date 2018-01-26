/*
 * Author: Minho Kim (ISKU)
 * Date: January 27, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1834
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong();

		long sum = 0;
		for (int i = 1; i < N; i++)
			sum += i * N + i;

		System.out.print(sum);
	}
}