/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.06
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/12116
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong();

		for (long i = 1; i * i <= N << 1; i++) {
			long p = N << 1;

			if (p % (i + 1) == 0) {
				p = p / (i + 1);
				p -= i;

				if (p > 0 && p % 2 == 0) {
					p >>= 1;
					System.out.printf("%d %d\n", p, p + i);
				}
			}
		}
	}
}