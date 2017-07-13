/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2703
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			char[] line = input.nextLine().toCharArray();
			String[] letter = input.nextLine().split("");

			for (int i = 0; i < line.length; i++) {
				if (line[i] >= 65 && line[i] <= 91)
					System.out.print(letter[(int) line[i] % 65]);
				else
					System.out.print(line[i]);
			}

			System.out.println();
		}
	}
}