/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.16
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1735
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int firstTop = input.nextInt();
		int firstBottom = input.nextInt();
		int secondTop = input.nextInt();
		int secondBottom = input.nextInt();
		int top = firstBottom * secondTop + secondBottom * firstTop;
		int bottom = firstBottom * secondBottom;
		System.out.println(top / gcd(bottom, top) + " " + bottom / gcd(bottom, top));
	}

	private static int gcd(int A, int B) {
		if (B > A)
			return gcd(B, A);
		if (A % B == 0)
			return B;
		else
			return gcd(B, A % B);
	}
}