/* 
 * Author: Minho Kim (ISKU)
 * Date: January 7, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15351
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = Integer.parseInt(input.nextLine());

		while (N-- > 0) {
			char[] line = input.nextLine().toCharArray();
			int sum = 0;

			for (char c : line)
				if (c != 32)
					sum += (c % 64);

			System.out.println((sum == 100) ? "PERFECT LIFE" : sum);
		}
	}
}