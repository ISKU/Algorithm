/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.03
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2083
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			String name = input.next();
			int age = input.nextInt();
			int kg = input.nextInt();

			if (name.equals("#"))
				break;

			System.out.printf("%s %s\n", name, (age > 17 || kg >= 80) ? "Senior" : "Junior");
		}
	}
}