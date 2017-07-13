/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.07.19
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2439
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		for (int N = input.nextInt(), i = 1; i <= N; i++) {
			for (int j = N - i; j >= 1; j--)
				System.out.print(" ");
			for (int j = i; j >= 1; j--)
				System.out.print("*");
			System.out.println();
		}
	}
}