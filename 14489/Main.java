/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14489
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		long A = input.nextLong();
		long B = input.nextLong();
		long C = input.nextLong();

		System.out.print((A + B) >= C * 2 ? (A + B) - C * 2 : A + B);
	}
}
