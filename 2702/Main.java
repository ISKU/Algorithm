/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.24
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2702
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int numberA = input.nextInt();
			int numberB = input.nextInt();
			int gcd = 0;
			int lcm = 0;

			for (int i = 1; i <= Math.max(numberA, numberB); i++) {
				if (numberA % i == 0 && numberB % i == 0)
					if (i > gcd)
						gcd = i;
			}
			lcm = (numberA * numberB) / gcd;

			System.out.println(lcm + " " + gcd);
		}
	}
}