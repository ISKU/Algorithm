/*
 * Author: Minho Kim (ISKU)
 * Date: November 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16503
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K1 = sc.nextInt();
		String O1 = sc.next();
		int K2 = sc.nextInt();
		String O2 = sc.next();
		int K3 = sc.nextInt();

		int first = calculate(calculate(K1, O1, K2), O2, K3);
		int second = calculate(K1, O1, calculate(K2, O2, K3));
		System.out.println(Math.min(first, second));
		System.out.println(Math.max(first, second));
	}

	private static int calculate(int A, String operator, int B) {
		switch (operator) {
		case "*":
			return A * B;
		case "/":
			return A / B;
		case "+":
			return A + B;
		case "-":
			return A - B;
		default:
			return 0;
		}
	}
}