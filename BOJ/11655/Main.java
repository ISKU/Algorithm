/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11655
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String sentence = new Scanner(System.in).nextLine();
		for (int index = 0; index < sentence.length(); index++) {
			char currentChar = sentence.charAt(index);

			if (currentChar >= 65 && currentChar <= 77)
				System.out.print((char) (currentChar + 13));
			else if (currentChar >= 78 && currentChar <= 90)
				System.out.print((char) (currentChar - 13));
			else if (currentChar >= 97 && currentChar <= 109)
				System.out.print((char) (currentChar + 13));
			else if (currentChar >= 110 && currentChar <= 122)
				System.out.print((char) (currentChar - 13));
			else
				System.out.print(currentChar);
		}
	}
}