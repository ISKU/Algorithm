/*
 * Author: Minho Kim (ISKU)
 * Date: January 17, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1475
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		String[] N = new Scanner(System.in).next().split("");
		int[] digit = new int[10];

		for (String i : N)
			digit[Integer.parseInt(i)]++;

		int temp = digit[6] + digit[9];
		digit[6] = (temp % 2 == 1) ? temp / 2 + 1 : temp / 2;
		digit[9] = temp / 2;

		int max = 0;
		for (int i = 0; i < 10; i++)
			max = Math.max(max, digit[i]);

		System.out.print(max);
	}
}