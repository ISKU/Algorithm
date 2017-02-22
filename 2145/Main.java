/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2145
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String[] number = input.next().split("");
			int sum;

			if (number[0].equals("0"))
				break;

			do {
				sum = 0;
				for (int i = 0; i < number.length; i++)
					sum += Integer.parseInt(number[i]);

				number = String.valueOf(sum).split("");
			} while (sum >= 10);

			System.out.println(sum);
		}
	}
}