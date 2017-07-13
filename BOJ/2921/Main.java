/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.28
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2921
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		int n = new Scanner(System.in).nextInt();
		System.out.print((n * (n + 1) * (n + 2)) / 2);
	}
}