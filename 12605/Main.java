/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12605
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		for (int tCase = 1; tCase <= testCase; tCase++) {
			StringBuilder output = new StringBuilder(String.format("Case #%d:", tCase));
			String[] words = input.nextLine().split(" ");

			for (int i = words.length - 1; i >= 0; i--)
				output.append(" ").append(words[i]);

			System.out.println(output);
		}
	}
}