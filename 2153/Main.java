/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2153
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Boolean> prime = new ArrayList<Boolean>();
		char[] word = input.nextLine().toCharArray();

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
		prime.set(1, true);

		int sum = 0;
		for (int i = 0; i < word.length; i++) {
			if (word[i] < 97)
				sum += word[i] - 65 + 27;
			else
				sum += word[i] - 96;
		}

		System.out.println(prime.get(sum) ? "It is a prime word." : "It is not a prime word.");
	}
}