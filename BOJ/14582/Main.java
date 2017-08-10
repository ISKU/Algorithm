/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.08.10
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14582
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] ulim = new int[9];
		int[] star = new int[9];

		for (int i = 0; i < 9; i++)
			ulim[i] = input.nextInt();
		for (int i = 0; i < 9; i++)
			star[i] = input.nextInt();

		boolean answer = false;
		for (int i = 0, sumA = 0, sumB = 0; i < 9; i++) {
			sumA += ulim[i];
			if (sumA > sumB)
				answer = true;
			sumB += star[i];
		}

		System.out.print(answer ? "Yes" : "No");
	}
}