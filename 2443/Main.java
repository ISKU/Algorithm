/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.30
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2443
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfLines = input.nextInt(); // number of lines

		for (int currentLine = 0; currentLine < numberOfLines; currentLine++) {
			for (int space = currentLine; space > 0; space--)
				System.out.print(" "); // k, k = 0, 1 ,2 ...
			for (int star = (2 * numberOfLines) - (2 * currentLine) - 1; star > 0; star--)
				System.out.print("*"); // 2n - 2k -1
			System.out.println();
		}
	}
}