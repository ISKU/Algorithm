/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.15
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2386
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String letter = input.next().toLowerCase();
			String line = input.nextLine().toLowerCase();

			if (letter.equals("#"))
				break;

			int count = 0;
			while (line.contains(letter)) {
				line = line.replaceFirst(letter, "");
				count++;
			}

			System.out.println(letter + " " + count);
		}
	}
}