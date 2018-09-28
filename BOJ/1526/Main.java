/*
 * Author: Minho Kim (ISKU)
 * Date: September 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1526
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		for (int i = N; i >= 4; i--) {
			int n = i;
			boolean check = true;

			while (n > 0) {
				if (n % 10 != 4 && n % 10 != 7) {
					check = false;
					break;
				}
				n /= 10;
			}

			if (check) {
				System.out.print(i);
				break;
			}
		}
	}
}