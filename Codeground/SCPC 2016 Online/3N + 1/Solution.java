/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.06.29
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.codeground.org/
 */

import java.util.Scanner;
import java.io.IOException;
import java.math.BigInteger;

public class Solution {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		BigInteger bi = new BigInteger("9223372036854775808");
		int number;
		int temp;
		int count = 0;
		int k = 1;

		k = scan.nextInt();
		for (int t = 1; t <= k; t++) {
			System.out.printf("Case #%d\n", t);
			number = scan.nextInt();
			for (int j = 0; j <= Long.MAX_VALUE; j++) {
				for (temp = j; temp > 1; count++) {
					if (temp % 2 == 0)
						temp = temp / 2;
					else
						temp = (3 * temp) + 1;
				}
				if (count == number) {
					if (j == 0)
						j = 1;
					if (number == 63)
						System.out.printf(j + " " + bi.max(bi) + "\n");
					else
						System.out.printf(j + " " + (long) (Math.pow(2, number)) + "\n");
					break;
				}
				count = 0;
			}
		}

	}
}