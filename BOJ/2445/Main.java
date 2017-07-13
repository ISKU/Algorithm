/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2445
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for (int i = 1; i <= 2 * n - 1; i++) { // number of lines: 2n-1
			int k = i;
			if (k > n) // reverse condition
				k = k - (i - n) * 2;
			for (int frontStar = 0; frontStar < k; frontStar++)
				System.out.print("*");
			for (int space = 0; space < 2 * n - 2 * k; space++)
				System.out.print(" ");
			for (int rearStar = 0; rearStar < k; rearStar++)
				System.out.print("*");
			System.out.println();
		}
	}
}