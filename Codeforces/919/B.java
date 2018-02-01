/*
 * Author: Minho Kim (ISKU)
 * Date: January 31, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/919/B
 */

import java.util.*;

public class B {
	public static void main(String... args) throws Exception {
		int k = new Scanner(System.in).nextInt();
		int i = 1;
		int count = 0;

		while (k != count) {
			int number = i++;
			int sum = 0;

			while (number > 0) {
				sum += number % 10;
				if (sum > 10)
					break;
				number /= 10;
			}

			if (sum == 10)
				count++;
		}

		System.out.print(i - 1);
	}
}