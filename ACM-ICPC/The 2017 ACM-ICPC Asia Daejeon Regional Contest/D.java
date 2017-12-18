/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.11.11
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2017/regional/problemset-2017.pdf
 */

import java.util.*;

public class D {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		HashSet<Integer> set = new HashSet<Integer>() {{
				add(4); add(16); add(37); add(58); add(89); add(145); add(42); add(20);
		}};

		while (!set.contains(N)) {
			String[] digits = String.valueOf(N).split("");
			N = 0;

			for (String digit : digits)
				N += Integer.parseInt(digit) * Integer.parseInt(digit);

			if (N == 1) {
				System.out.print("HAPPY");
				System.exit(0);
			}
		}

		System.out.print("UNHAPPY");
	}
}