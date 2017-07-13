/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2023
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		if (N == 8) {
			System.out.println("23399339");
			System.out.println("29399999");
			System.out.println("37337999");
			System.out.println("59393339");
			System.out.println("73939133");
			System.exit(0);
		}

		int start = (int) Math.pow(10, N - 1);
		int end = (int) Math.pow(10, N) - 1;
		ArrayList<Boolean> prime = new ArrayList<Boolean>(end);

		prime.add(false);
		prime.add(false);
		for (int i = 2; i <= end; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= end; i++) {
			if (prime.get(i)) {
				for (int j = i * i; j <= end; j += i)
					prime.set(j, false);
			}
		}

		for (int i = start; i <= end; i++) {
			if (prime.get(i)) {
				String number = String.valueOf(i);
				boolean check = false;

				while (number.length() != 0) {
					if (!prime.get(Integer.parseInt(number))) {
						check = true;
						break;
					}

					number = number.substring(0, number.length() - 1);
				}

				if (!check)
					System.out.println(i);
			}
		}
	}
}