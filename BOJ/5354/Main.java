/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.21
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5354
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int numberOfLines = input.nextInt();
			if (numberOfLines == 1) {
				System.out.println("#\n");
				continue;
			}

			for (int count = 0; count < numberOfLines; count++)
				System.out.print("#");
			System.out.println();

			for (int count = 0; count < numberOfLines - 2; count++) {
				System.out.print("#");
				for (int print = 0; print < numberOfLines - 2; print++)
					System.out.print("J");
				System.out.println("#");
			}

			for (int count = 0; count < numberOfLines; count++)
				System.out.print("#");
			System.out.println("\n");
		}
	}
}