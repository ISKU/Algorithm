/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.31
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2523
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		for (int i = 1; i <= 2 * n - 1; i++) { // number of lines: 2n-1
			int k = i;
			if (k > n) // reverse condition
				k = n - (i - n);
			for (int star = 0; star < k; star++)
				System.out.print("*");
			System.out.println();
		}
	}
}