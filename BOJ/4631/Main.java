/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.05.17
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4631
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		for (int tCase = 1;; tCase++) {
			int n = input.nextInt();
			if (n == 0)
				break;

			String[] names = new String[n];
			for (int i = 0; i < n; i++)
				names[i] = input.next();

			Arrays.sort(names, (a, b) -> {
				if (a.length() < b.length())
					return -1;
				else if (a.length() > b.length())
					return 1;
				else
					return 0;
			});

			String[] output = new String[n];
			for (int i = 0, j = 0, k = n - 1; i < n; i += 2) {
				output[j++] = names[i];
				if (i + 1 < n)
					output[k--] = names[i + 1];
			}

			System.out.printf("SET %d\n", tCase);
			for (String name : output)
				System.out.println(name);
		}
	}
}