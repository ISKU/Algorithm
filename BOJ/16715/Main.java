/*
 * Author: Minho Kim (ISKU)
 * Date: January 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16715
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int answer = 0;
		int system = 0;

		for (int d = N; d >= 2; d--) {
			int n = N;
			int sum = 0;

			while (n > 0) {
				sum += n % d;
				n /= d;
			}

			if (sum >= answer) {
				answer = sum;
				system = d;
			}
		}

		System.out.printf("%d %d", answer, system);
	}
}