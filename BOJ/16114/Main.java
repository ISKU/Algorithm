/*
 * Author: Minho Kim (ISKU)
 * Date: September 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16114
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int N = sc.nextInt();

		if (N >= 3 && N % 2 == 1)
			exit("ERROR");
		if (X > 0 && N == 0)
			exit("INFINITE");

		int dec = N / 2;
		int count = 0;
		if (N == 1)
			X = -X;
		if (X <= 0)
			exit("0");
		if (dec == 0)
			exit("INFINITE");
		for (int i = X - dec; i > 0; i -= dec)
			count++;
		System.out.print(count);
	}

	private static void exit(String value) {
		System.out.print(value);
		System.exit(0);
	}
}