/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5636
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Boolean> prime = new ArrayList<Boolean>(100000);
		ArrayList<String> onlyPrime = new ArrayList<String>(100000);

		prime.add(false);
		prime.add(false);
		for (int i = 2; i <= 100000; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= 100000; i++) {
			if (prime.get(i)) {
				for (int j = i * i; j <= 100000; j += i)
					prime.set(j, false);
			}
		}

		for (int i = 100000; i >= 2; i--)
			if (prime.get(i))
				onlyPrime.add(String.valueOf(i));

		while (true) {
			String number = input.nextLine();
			if (number.equals("0"))
				break;

			int i = 0;
			for (; i < onlyPrime.size(); i++)
				if (number.contains(onlyPrime.get(i)))
					break;

			System.out.println(onlyPrime.get(i));
		}
	}
}