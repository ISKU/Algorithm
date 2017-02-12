/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6996
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			String first = input.next();
			String second = input.next();
			System.out.print(first + " & " + second);

			if (first.length() == second.length()) {
				for (int i = 0; i < first.length(); i++)
					second = second.replaceFirst(first.charAt(i) + "", "");

				System.out.println(second.equals("") ? " are anagrams." : " are NOT anagrams.");
			} else
				System.out.println(" are NOT anagrams.");
		}
	}
}