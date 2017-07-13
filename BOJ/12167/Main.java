/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.12
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12167
 */

import java.util.Scanner;

public class Main {
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