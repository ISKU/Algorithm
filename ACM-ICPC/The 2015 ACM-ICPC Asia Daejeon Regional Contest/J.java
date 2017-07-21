/* 
 * Author: Minho Kim (ISKU)
 * Date: 2016.09.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/2015/REGIONAL/problemset-2015.pdf
 */

import java.util.Scanner;
import java.util.ArrayList;

public class J {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Boolean> prime = new ArrayList<Boolean>() {{
				add(false);
				add(false);
		}};

		for (int i = 2; i <= 1000; i++)
			prime.add(i, true);

		for (int i = 2; i * i <= 1000; i++)
			if (prime.get(i))
				for (int j = i * i; j <= 1000; j += i)
					prime.set(j, false);

		int testCase = input.nextInt();
		while (testCase-- > 0) {
			int number = input.nextInt();

			CORRECT: 
			for (int i = 0; i < number; i++)
				for (int j = 0; j < number; j++)
					for (int k = 0; k < number; k++)
						if (prime.get(i) && prime.get(j) && prime.get(k))
							if (number == (i + j + k)) {
								System.out.printf("%d %d %d\n", i, j, k);
								break CORRECT;
							}
		}
	}
}