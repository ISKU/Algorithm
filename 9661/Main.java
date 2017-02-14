/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9661
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		long N = new Scanner(System.in).nextLong() % 5;

		if (N == 1 || N == 3 || N == 4)
			System.out.print("SK");
		else if (N == 0 || N == 2)
			System.out.print("CY");
	}
}