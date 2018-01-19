/*
 * Author: Minho Kim (ISKU)
 * Date: January 19, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13458
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] site = new int[N];
		for (int i = 0; i < N; i++)
			site[i] = sc.nextInt();

		int B = sc.nextInt(), C = sc.nextInt();
		long answer = 0;

		for (int num : site) {
			num -= B;
			if (num > 0)
				answer += (num % C > 0) ? num / C + 1 : num / C;
		}

		System.out.print(answer + N);
	}
}