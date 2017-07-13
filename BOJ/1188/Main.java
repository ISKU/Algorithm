/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.07
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1188
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int MM = M;

		while (N != 0) {
			if (N < M) {
				int t = N;
				N = M;
				M = t;
			}
			N = N - M;
		}

		System.out.print(MM - M);
	}
}