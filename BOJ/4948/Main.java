/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4948
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Boolean> prime = new ArrayList<Boolean>(300000);

		prime.add(false);
		prime.add(false);
		for (int i = 2; i <= 300000; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= 300000; i++) {
			if (prime.get(i)) {
				for (int j = i * i; j <= 300000; j += i)
					prime.set(j, false);
			}
		}

		while (true) {
			int n = input.nextInt();
			if (n == 0)
				break;

			int count = 0;
			for (int i = n + 1; i <= 2 * n; i++)
				if (prime.get(i))
					count++;

			System.out.println(count);
		}
	}
}