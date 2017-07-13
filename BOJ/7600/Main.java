/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7600
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			char[] line = input.nextLine().toUpperCase().toCharArray();
			boolean[] letter = new boolean[26];

			if (line[0] == '#')
				break;

			for (int i = 0; i < line.length; i++) {
				if (line[i] >= 65 && line[i] <= 91)
					letter[(int) line[i] % 65] = true;
			}

			int count = 0;
			for (int i = 0; i < 26; i++)
				if (letter[i])
					count++;

			System.out.println(count);
		}
	}
}