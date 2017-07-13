/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2581
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int M = input.nextInt();
		int N = input.nextInt();
		ArrayList<Boolean> prime = new ArrayList<Boolean>();

		prime.add(false);
		prime.add(false);
		for (int i = 2; i <= 1000000; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= 1000000; i++) {
			if (prime.get(i)) {
				for (int j = i * i; j <= 1000000; j += i)
					prime.set(j, false);
			}
		}

		int sum = 0;
		int first = 0;
		boolean check = true;
		for (int i = M; i <= N; i++) {
			if (check && prime.get(i)) {
				check = false;
				first = i;
			}
			if (prime.get(i))
				sum += i;
		}

		System.out.println(sum == 0 ? -1 : sum + "\n" + first);
	}
}