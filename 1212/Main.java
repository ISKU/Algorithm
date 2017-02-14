/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1212
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		StringBuilder output = new StringBuilder();
		String number = new Scanner(System.in).nextLine();

		output.append(Integer.toBinaryString(Integer.parseInt(number.charAt(0) + "", 8)));
		for (int i = 1, size = number.length(); i < size; i++)
			output.append(String.format("%03d",
					Integer.parseInt(Integer.toBinaryString(Integer.parseInt(number.charAt(i) + "", 8)))));

		System.out.println(output);
	}
}