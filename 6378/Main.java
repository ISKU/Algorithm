/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6378
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String number = input.next();

			if (number.equals("0"))
				break;

			while (true) {
				String[] digit = number.split("");
				int sum = 0;
				for (int i = 0; i < digit.length; i++)
					sum += Integer.parseInt(digit[i]);

				if (sum >= 10)
					number = String.valueOf(sum);
				else {
					System.out.println(sum);
					break;
				}
			}
		}
	}
}