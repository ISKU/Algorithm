/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.26
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10801
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int[] A = new int[10];
		int[] B = new int[10];
		int winA = 0, winB = 0, draw = 0;

		for (int i = 0; i < 10; i++)
			A[i] = input.nextInt();
		for (int i = 0; i < 10; i++)
			B[i] = input.nextInt();

		for (int i = 0; i < 10; i++) {
			if (A[i] > B[i])
				winA++;
			else if (A[i] < B[i])
				winB++;
			else
				draw++;
		}

		System.out.print((winA > winB) ? "A" : (winA < winB) ? "B" : "D");
	}
}