/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.02
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10093
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		long A = input.nextLong();
		long B = input.nextLong();

		System.out.println((A == B) ? 0 : (A > B) ? A - B - 1 : B - A - 1);
		if (A < B)
			for (long i = A + 1; i < B; i++)
				System.out.printf("%d ", i);
		else
			for (long i = B + 1; i < A; i++)
				System.out.printf("%d ", i);
	}
}