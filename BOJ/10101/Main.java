/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.18
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10101
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		int sum = A + B + C;

		if (A == 60 && B == 60 && C == 60)
			System.out.println("Equilateral");
		else if (sum == 180) {
			if (A == B || A == C || B == C)
				System.out.println("Isosceles");
			else
				System.out.println("Scalene");
		} else
			System.out.println("Error");
	}
}