/*
 * Author: Minho Kim (ISKU)
 * Date: August 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13241
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(lcm(sc.nextLong(), sc.nextLong()));
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
}