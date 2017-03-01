/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.01
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4504
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		while (true) {
			int number = input.nextInt();
			if (number == 0)
				break;
			System.out.printf("%d is %sa multiple of %d.\n", number, number % n == 0 ? "" : "NOT ", n);
		}
	}
}