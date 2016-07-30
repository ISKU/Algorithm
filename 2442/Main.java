/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.30
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2442
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfLines = input.nextInt(); // number of lines

		for (int currentLine = 1; currentLine <= numberOfLines; currentLine++) {
			for (int space = numberOfLines - currentLine; space > 0; space--)
				System.out.print(" "); // n - current line number
			for (int star = (2 * currentLine) - 1; star > 0; star--)
				System.out.print("*"); // 2n - 1
			System.out.println();
		}
	}
}