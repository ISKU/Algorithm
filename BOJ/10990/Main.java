/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10990
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		// first line
		for (int i = 1; i < n; i++)
			System.out.print(" ");
		System.out.println("*");

		for (int i = 1; i < n; i++) {
			for (int space = 1; space < n - i; space++)
				System.out.print(" ");
			System.out.print("*");
			for (int space = 0; space < 2 * i - 1; space++)
				System.out.print(" ");
			System.out.println("*");
		}
	}
}