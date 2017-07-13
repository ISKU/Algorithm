/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11109
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();

		while (testCase-- > 0) {
			int d = input.nextInt();
			int n = input.nextInt();
			int s = input.nextInt();
			int p = input.nextInt();
			int par = d + n * p;
			int ser = n * s;
			System.out.println((par == ser) ? "does not matter" : (par > ser) ? "do not parallelize" : "parallelize");
		}
	}
}