/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5086
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int first = input.nextInt();
			int second = input.nextInt();

			if (first == 0 && second == 0)
				break;

			if (second % first == 0 && first < second)
				System.out.println("factor");
			else if (first % second == 0 && second < first)
				System.out.println("multiple");
			else
				System.out.println("neither");
		}
	}
}