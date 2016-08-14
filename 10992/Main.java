/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.14
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10992
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int numberOfLines = new Scanner(System.in).nextInt();

		if (numberOfLines > 1) {
			for (int space = 1; space < numberOfLines; space++)
				System.out.print(" ");
			System.out.println("*");
		}

		for (int line = numberOfLines - 2, count = 1; line > 0; line--, count++) {
			for (int space = line; space > 0; space--)
				System.out.print(" ");
			System.out.print("*");
			for (int space = 0; space < 2 * count - 1; space++)
				System.out.print(" ");
			System.out.println("*");
		}

		for (int star = 2 * numberOfLines - 1; star > 0; star--)
			System.out.print("*");
	}
}