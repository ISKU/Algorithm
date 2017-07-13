/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3896
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Boolean> prime = new ArrayList<Boolean>(1300000);
		int testCase = input.nextInt();

		prime.add(false);
		prime.add(false);
		for (int i = 2; i <= 1300000; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= 1300000; i++) {
			if (prime.get(i)) {
				for (int j = i * i; j <= 1300000; j += i)
					prime.set(j, false);
			}
		}

		while (testCase-- > 0) {
			int number = input.nextInt();
			int prevNumber = 0;
			int nextNumber = 0;

			for (int i = number; i >= 0; i--) {
				if (prime.get(i)) {
					prevNumber = i;
					break;
				}
			}
			for (int i = number; i <= 1300000; i++) {
				if (prime.get(i)) {
					nextNumber = i;
					break;
				}
			}

			if (nextNumber == 0 || prevNumber == 0) {
				System.out.println("0");
				continue;
			}

			System.out.println(nextNumber - prevNumber);
		}
	}
}