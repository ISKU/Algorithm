/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9660
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong();
		System.out.print(((N % 7) == 0 || N % 7 == 2) ? "CY" : "SK");
	}
}