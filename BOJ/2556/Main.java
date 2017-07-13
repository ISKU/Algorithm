/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2556
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		for (int i = 1; i <= n; i++) { // number of lines: n
			for (int j = 1; j <= n; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}