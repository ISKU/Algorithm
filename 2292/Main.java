/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2292
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int n = new Scanner(System.in).nextInt() - 1;

		int i = 1;
		while (n > 0) {
			n = n - (i * 6);
			i++;
		}

		System.out.print(i);
	}
}