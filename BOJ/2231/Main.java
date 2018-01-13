/*
 * Author: Minho Kim (ISKU)
 * Date: January 13, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2231
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			int number = i;
			int sum = i;

			while (number > 0) {
				sum += number % 10;
				number /= 10;
			}

			if (sum == N) {
				answer = i;
				break;
			}
		}

		System.out.print(answer);
	}
}