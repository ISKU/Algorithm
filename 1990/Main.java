/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1990
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		b = b >= 10000000 ? 10000000 : b;
		ArrayList<Boolean> prime = new ArrayList<Boolean>(10000000);
		StringBuilder output = new StringBuilder();

		prime.add(false);
		prime.add(false);
		for (int i = 2; i <= 10000000; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= 10000000; i++) {
			if (prime.get(i)) {
				for (int j = i * i; j <= 10000000; j += i)
					prime.set(j, false);
			}
		}

		for (int i = a; i <= b; i++) {
			if (prime.get(i)) {
				String number = String.valueOf(i);
				int start = 0;
				int end = number.length() - 1;
				boolean check = false;

				for (; start < end; start++, end--) {
					if (number.charAt(start) != number.charAt(end)) {
						check = true;
						break;
					}
				}

				if (!check)
					output.append(number + "\n");
			}
		}

		System.out.println(output + "-1");
	}
}