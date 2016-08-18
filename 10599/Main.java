/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10599
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int A = input.nextInt();
			int B = input.nextInt();
			int C = input.nextInt();
			int D = input.nextInt();

			if (A == 0 && B == 0 && C == 0 && D == 0)
				break;

			System.out.print(Math.abs(C - B) + " ");
			System.out.println(Math.abs(D - A));
		}
	}
}