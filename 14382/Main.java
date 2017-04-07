/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14382
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		for (int t = 1; t <= testCase; t++) {
			long N = input.nextLong();
			int check = 0;

			if (N == 0)
				System.out.printf("Case #%d: INSOMNIA\n", t);
			else {
				for (long i = 1; ; i++) {
					String[] number = String.valueOf(N * i).split("");

					for (int j = 0; j < number.length; j++)
						check |= 1 << Integer.parseInt(number[j]);

					if (check == 1023) {
						System.out.printf("Case #%d: %d\n", t, N * i);
						break;
					}
				}
			}
		}
	}
}