/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.03.29
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13240
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				System.out.print(((j + i) % 2) == 0 ? "*" : ".");
			System.out.println();
		}
	}
}