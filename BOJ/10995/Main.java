/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.14
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10995
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int numberOfLines = new Scanner(System.in).nextInt();

		for (int line = 0; line < numberOfLines; line++) {
			if (line % 2 == 0)
				for (int star = 0; star < numberOfLines; star++)
					System.out.print("* ");
			else
				for (int star = 0; star < numberOfLines; star++)
					System.out.print(" *");
			System.out.println();
		}
	}
}