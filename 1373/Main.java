/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1373
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String... args) {
		ArrayList<String> octal = new ArrayList<String>();
		StringBuilder output = new StringBuilder();

		String number = new Scanner(System.in).nextLine();

		for (int i = number.length() - 1; i >= 0; i -= 3) {
			String cur = "";

			for (int j = 0; j < 3; j++) {
				if (i - j < 0)
					break;
				cur = number.charAt(i - j) + cur;
			}

			octal.add(Integer.toOctalString(Integer.parseInt(cur, 2)));
		}

		for (int i = octal.size() - 1; i >= 0; i--)
			output.append(octal.get(i));
		System.out.println(output);
	}
}