/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1978
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfPrimeNumbers = 0;

		for (int count = input.nextInt(); count > 0; count--) {
			int primeNumber = input.nextInt();
			int divisor = 2;

			if (primeNumber == 1)
				continue;

			while (primeNumber % divisor != 0)
				divisor++;
			if (primeNumber == divisor)
				numberOfPrimeNumbers++;
		}

		System.out.println(numberOfPrimeNumbers);
	}
}