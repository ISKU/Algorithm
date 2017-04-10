/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14445
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		long n = new Scanner(System.in).nextLong();
		System.out.print((n <= 1) ? 0 : (n / 2) + (n % 2));
	}
}