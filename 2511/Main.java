/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.04.29
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2511
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] A = new int[10];
		int[] B = new int[10];
		String[] result = new String[10];
		int scoreA = 0, scoreB = 0;

		for (int i = 0; i < 10; i++)
			A[i] = input.nextInt();
		for (int i = 0; i < 10; i++)
			B[i] = input.nextInt();

		for (int i = 0; i < 10; i++) {
			if (A[i] < B[i]) {
				scoreB += 3;
				result[i] = "B";
			} else if (A[i] > B[i]) {
				scoreA += 3;
				result[i] = "A";
			} else {
				scoreA++;
				scoreB++;
				result[i] = "D";
			}
		}

		System.out.printf("%d %d\n", scoreA, scoreB);
		if (scoreA < scoreB)
			System.out.print("B");
		else if (scoreA > scoreB)
			System.out.print("A");
		else {
			for (int i = 9; i >= 0; i--)
				if (!result[i].equals("D")) {
					System.out.print(result[i]);
					System.exit(0);
				}
			System.out.print("D");
		}
	}
}