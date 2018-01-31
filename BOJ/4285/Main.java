/*
 * Author: Minho Kim (ISKU)
 * Date: January 31, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4285
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int k = sc.nextInt();
			if (k == 0)
				break;
			int m = sc.nextInt();

			HashSet<Integer> set = new HashSet<Integer>();
			while (k-- > 0)
				set.add(sc.nextInt());

			boolean answer = true;
			while (m-- > 0) {
				int r = sc.nextInt();
				int c = sc.nextInt();

				int count = 0;
				while (r-- > 0)
					if (set.contains(sc.nextInt()))
						count++;

				if (count < c)
					answer = false;
			}

			System.out.println((answer) ? "yes" : "no");
		}
	}
}