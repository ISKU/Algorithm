/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9971
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		char[] plain = new char[] { 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U' };

		while (true) {
			String line = input.nextLine();
			if (line.equals("ENDOFINPUT"))
				break;

			for (char letter : input.nextLine().toCharArray())
				System.out.print((letter >= 65 && letter <= 90) ? plain[letter % 65] : letter);
			System.out.println();
			input.nextLine();
		}
	}
}