/*
 * Author: Minho Kim (ISKU)
 * Date: January 14, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2975
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int a = sc.nextInt();
			String com = sc.next();
			int b = sc.nextInt();

			if (a == 0 && b == 0 && "W".equals(com))
				break;
			System.out.println("W".equals(com) ? (a - b < -200 ? "Not allowed" : a - b) : a + b);
		}
	}
}