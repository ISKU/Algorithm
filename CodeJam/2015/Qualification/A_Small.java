/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.12
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://code.google.com/codejam/contest/6224486/dashboard#s=p0
 */

import java.util.Scanner;

public class A_Small {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int tCase = 1; tCase <= testCase; tCase++) {
			input.nextInt();
			char[] S = input.next().toCharArray();
			int ans = 0;
			int sum = 0;

			for (int i = 0; i < S.length; ++i) {
				int num = S[i] - '0';

				if (num > 0 && sum < i) {
					ans += i - sum;
					sum = i;
				}
				sum += num;
			}

			System.out.printf("Case #%d: %d\n", tCase, ans);
		}
	}
}