/*
 * Author: Minho Kim (ISKU)
 * Date: December 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16674
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] digits = new int[10];
		if (N == 0)
			digits[0] = 1;
		while (N > 0) {
			digits[N % 10]++;
			N /= 10;
		}

		if (!(digits[2] >= 1 || digits[0] >= 1 || digits[1] >= 1 || digits[8] >= 1))
			exit(0);
		for (int i = 0; i <= 9; i++) {
			if (i == 2 || i == 0 || i == 1 || i == 8)
				continue;
			if (digits[i] >= 1)
				exit(0);
		}
		if (!(digits[2] >= 1 && digits[0] >= 1 && digits[1] >= 1 && digits[8] >= 1))
			exit(1);
		if (!(digits[2] == digits[0] && digits[0] == digits[1] && digits[1] == digits[8]))
			exit(2);
		System.out.print(8);
	}

	private static void exit(int value) {
		System.out.print(value);
		System.exit(0);
	}
}