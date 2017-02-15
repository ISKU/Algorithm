/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.15
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12400
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());
		char[] ref = new char[] { 'y', 'h', 'e', 's', 'o', 'c', 'v', 'x', 'd', 'u', 'i', 'g', 'l', 'b', 'k', 'r', 'z',
				't', 'n', 'w', 'j', 'p', 'f', 'm', 'a', 'q' };

		for (int i = 1; i <= testCase; i++) {
			char[] line = input.nextLine().toCharArray();

			for (int index = 0; index < line.length; index++) {
				if (line[index] == ' ')
					continue;

				line[index] = ref[(int) line[index] % 97];
			}

			System.out.printf("Case #%d: ", i);
			for (int index = 0; index < line.length; index++)
				System.out.print(line[index]);
			System.out.println();
		}
	}
}