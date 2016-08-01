/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.01
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1100
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int numberOfChessPiece = 0;

		for (int line = 0; line < 8; line++) {
			String onTheLine = input.next();
			int location = (line % 2 == 0) ? 0 : 1;
			while (location < 8) {
				if (onTheLine.charAt(location) == 'F')
					numberOfChessPiece++;
				location = location + 2;
			}
		}

		System.out.println(numberOfChessPiece);
	}
}