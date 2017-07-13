/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.30
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13199
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int p = input.nextInt();
			int m = input.nextInt();
			int f = input.nextInt();
			int c = input.nextInt();

			int count = 0, coupon = 0;
			coupon = (m / p) * c;
			coupon = ((coupon / f) * c) + (coupon % f);

			while (coupon > 0) {
				if (coupon / f > 0) {
					count += coupon / f;
					coupon = ((coupon / f) * c) + (coupon % f);
				} else
					coupon = coupon / f;
			}

			System.out.println(count);
		}
	}
}