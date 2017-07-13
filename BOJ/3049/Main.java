/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3049
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int n = new Scanner(System.in).nextInt();
		int out = 1;

		for (int i = 1; i <= 4; i++)
			out = out * (n - i + 1) / i;
		System.out.print(out);
	}
}