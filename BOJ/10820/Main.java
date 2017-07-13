/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.14
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10820
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			int lowerCase = 0, upperCase = 0, number = 0, space = 0;
			String sentence = input.nextLine();

			for (int index = 0; index < sentence.length(); index++) {
				int asciiNumber = (int) sentence.charAt(index);

				if (asciiNumber >= 97 && asciiNumber <= 122)
					lowerCase++;
				else if (asciiNumber >= 65 && asciiNumber <= 90)
					upperCase++;
				else if (asciiNumber >= 48 && asciiNumber <= 57)
					number++;
				else
					space++;
			}
			System.out.println(lowerCase + " " + upperCase + " " + number + " " + space);
		}
	}
}