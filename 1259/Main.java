/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.03
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1259
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String number = input.next();
			if (number.equals("0"))
				break;

			System.out.println(isPalindrome(number.split("")));
		}
	}

	private static String isPalindrome(String... word) {
		for (int i = 0, j = word.length - 1; i < j; i++, j--)
			if (!word[i].equals(word[j]))
				return "no";

		return "yes";
	}
}