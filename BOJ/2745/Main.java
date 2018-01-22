/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2745
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		char[] number = sc.next().toCharArray();
		int pos = sc.nextInt();

		int sum = 0;
		for (int i = number.length - 1, digit = 0; i >= 0; i--, digit++) {
			if (number[i] >= 65)
				sum += (int) (number[i] - 55) * (int) Math.pow(pos, digit);
			else
				sum += (int) (number[i] - 48) * (int) Math.pow(pos, digit);
		}

		System.out.print(sum);
	}
}