/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.06.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14624
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int N = new Scanner(System.in).nextInt();

		if ((N & 1) == 0) {
			System.out.print("I LOVE CBNU");
			System.exit(0);
		}

		for (int i = 1; i <= N; i++)
			System.out.print("*");
		System.out.println();

		for (int i = 1; i <= N / 2; i++)
			System.out.print(" ");
		System.out.println("*");

		for (int i = N / 2, j = 1; i > 0; i--, j++) {
			for (int fSp = i - 1; fSp > 0; fSp--)
				System.out.print(" ");
			System.out.print("*");

			for (int sSp = 1; sSp <= j * 2 - 1; sSp++)
				System.out.print(" ");
			System.out.println("*");
		}
	}
}