/*
 * Author: Minho Kim (ISKU)
 * Date: January 22, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1065
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();
		int count = 0;

		for (int i = 1; i <= N; i++) {
			String[] digit = String.valueOf(i).split("");

			if (digit.length <= 2) {
				count++;
				continue;
			}

			int key = Integer.parseInt(digit[1]) - Integer.parseInt(digit[0]);
			boolean check = true;
			for (int j = 2; j < digit.length; j++)
				if (Integer.parseInt(digit[j]) - Integer.parseInt(digit[j - 1]) != key)
					check = false;

			if (check)
				count++;
		}

		System.out.print(count);
	}
}