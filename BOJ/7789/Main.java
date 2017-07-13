/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7789
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Boolean> prime = new ArrayList<Boolean>(10000000);

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

		int number = input.nextInt();
		String first = input.next();
		System.out.print(prime.get(number) && prime.get(Integer.parseInt(first + number)) ? "Yes" : "No");
	}
}