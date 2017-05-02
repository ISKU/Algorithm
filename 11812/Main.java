/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.02
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11812
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		long N = input.nextLong();
		long K = input.nextLong();
		int Q = input.nextInt();

		while (Q-- > 0) {
			long x = input.nextLong();
			long y = input.nextLong();

			if (K == 1) {
				System.out.println((y - x) < 0 ? -(y - x) : y - x);
				continue;
			}

			int count = 0;
			while (x != y) {
				if (x < y) {
					long temp = x;
					x = y;
					y = temp;
				}

				x = (x + (K - 2)) / K;
				count++;
			}

			System.out.println(count);
		}
	}
}