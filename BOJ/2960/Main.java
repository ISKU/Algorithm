/*
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.10.02
 * email: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2960
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] prime = new int[input.nextInt() + 1];
		boolean[] checkPrime = new boolean[prime.length + 1];
		int deleteCount = input.nextInt();
		int deleteNumber = 0;
		int length = 0;

		OUT:
		for (int i = 2; i < prime.length; i++) {
			if (!checkPrime[i]) {
				prime[length++] = i;
				deleteNumber = i;
				deleteCount--;
			}

			for (int j = i * i; j < prime.length; j += i) {
				if (checkPrime[j] == false) {
					checkPrime[j] = true;
					deleteCount--;
					deleteNumber = j;

					if (deleteCount == 0) {
						System.out.print(deleteNumber);
						break OUT;
					}
				}
			}

			if (deleteCount == 0) {
				System.out.print(deleteNumber);
				break;
			}
		}
	}
}