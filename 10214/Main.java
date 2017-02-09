/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.09
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10214
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		for (int testCase = input.nextInt(); testCase > 0; testCase--) {
			int yonsei = 0;
			int korea = 0;

			for (int index = 0; index < 9; index++) {
				yonsei += input.nextInt();
				korea += input.nextInt();
			}

			System.out.println((yonsei == korea) ? "Draw" : (yonsei > korea) ? "Yonsei" : "Korea");
		}
	}
}