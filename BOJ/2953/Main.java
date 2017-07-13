/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2953
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		int n = 0, pOut = 0;
		for (int i = 0; i < 5; i++) {
			int point = 0;

			for (int j = 0; j < 4; j++)
				point += input.nextInt();

			if (pOut < point) {
				pOut = point;
				n = i + 1;
			}
		}

		System.out.println(n + " " + pOut);
	}
}