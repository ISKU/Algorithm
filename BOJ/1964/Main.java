/*
 * Author: Minho Kim (ISKU)
 * Date: January 18, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1964
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		long n = new Scanner(System.in).nextLong();
		System.out.print((((3 * n * n) + (5 * n) + 2) / 2) % 45678);
	}
}