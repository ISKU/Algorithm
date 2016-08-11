/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.11
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10996
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfLines = input.nextInt();

		if (numberOfLines == 1)
			System.out.print("*");
		else {
			for (int line = 0; line < numberOfLines * 2; line++) {
				int count = 0;

				if (line % 2 == 0) {
					while (true) {
						if (count++ == numberOfLines)
							break;
						System.out.print("*");

						if (count++ == numberOfLines)
							break;
						System.out.print(" ");
					}
				} else {
					while (true) {
						if (count++ == numberOfLines)
							break;
						System.out.print(" ");

						if (count++ == numberOfLines)
							break;
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
	}
}