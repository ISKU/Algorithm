/*
 * Author: Minho Kim (ISKU)
 * Date: July 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15897
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong();
		long upper = (long) Math.sqrt(N);
		long answer = 0;

		for (long i = 2; i <= upper; i++) {
			long l = ((N % i) == 0) ? N / i : N / i + 1;
			long r = (N % (i - 1) == 0) ? N / (i - 1) - 1 : N / (i - 1);
			answer += (r - l + 1) * i;
		}

		long lower = ((N % upper) == 0) ? N / upper : N / upper + 1;
		for (double i = 1; i < lower; i++)
			answer += Math.ceil(N / i);

		System.out.println(answer + 1);
	}
}
