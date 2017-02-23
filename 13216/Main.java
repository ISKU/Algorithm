/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.24
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13216
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		char[] match = new Scanner(System.in).nextLine().toCharArray();
		int winA = 0, winB = 0;

		int j = 0;
		for (int i = 0; i < 3; i++) {
			int A = 0;
			int B = 0;

			for (; j < match.length; j++) {
				if (A == 21 || B == 21) {
					if (A > B)
						winA++;
					else
						winB++;

					break;
				}

				if (match[j] == 'A')
					A++;
				else if (match[j] == 'B')
					B++;
			}

			System.out.print(A + "-" + B + "\n");
			if (j == match.length) {
				if (A > B)
					winA++;
				else
					winB++;

				break;
			}
		}

		System.out.println((winA > winB) ? "A" : "B");
	}
}