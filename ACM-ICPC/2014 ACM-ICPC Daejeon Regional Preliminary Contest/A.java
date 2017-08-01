/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.02.28
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * http://icpckorea.org/problems/2014/onlineset.pdf
 */

import java.util.Scanner;

public class A {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int h = input.nextInt();
			input.nextInt();
			int n = input.nextInt();
			System.out.printf("%d%02d\n", n % h != 0 ? n % h : h, n / h + (n % h != 0 ? 1 : 0));
		}
	}
}