/*
 * Author: Minho Kim (ISKU)
 * Date: January 24, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15474
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int X = (N % A > 0) ? (N / A) * B + B : (N / A) * B;
		int Y = (N % C > 0) ? (N / C) * D + D : (N / C) * D;
		System.out.print(Math.min(X, Y));
	}
}