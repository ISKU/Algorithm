/*
 * Author: Minho Kim (ISKU)
 * Date: February 14, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/934/B
 */

import java.util.*;

public class B {
	public static void main(String... args) {
		int K = new Scanner(System.in).nextInt();

		if (K >= 37)
			System.out.print(-1);
		else {
			for (int i = 0; i < K / 2; i++)
				System.out.print(8);
			if (K % 2 == 1)
				System.out.print(4);
		}
	}
}