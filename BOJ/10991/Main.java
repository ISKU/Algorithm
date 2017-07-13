/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.14
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10991
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int numberOfLines = new Scanner(System.in).nextInt();
		
		for (int line = numberOfLines; line > 0; line--) {
			for (int space = 1; space < line; space++)
				System.out.print(" ");
			for (int star = numberOfLines - line; star >= 0; star--)
				System.out.print("* ");
			System.out.println();
		}
	}
}