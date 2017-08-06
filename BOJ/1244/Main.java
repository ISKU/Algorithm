/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.06
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1244
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		boolean[] swit = new boolean[input.nextInt() + 1];

		for (int i = 1; i < swit.length; i++)
			swit[i] = (input.nextInt() == 1) ? true : false;

		int N = input.nextInt();
		while (N-- > 0) {
			int gender = input.nextInt();
			int number = input.nextInt();

			if (gender == 1) {
				int multiple = number;
				while (multiple < swit.length) {
					swit[multiple] = !swit[multiple];
					multiple += number;
				}
			}

			if (gender == 2) {
				for (int i = number - 1, j = number + 1; i >= 1 && j < swit.length; i--, j++) {
					if (swit[i] == swit[j]) {
						swit[i] = !swit[i];
						swit[j] = !swit[j];
					} else
						break;
				}
				swit[number] = !swit[number];
			}
		}

		for (int i = 1; i < swit.length; i++) {
			System.out.print(swit[i] ? "1 " : "0 ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
}