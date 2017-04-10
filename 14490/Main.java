/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.04.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14490
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		String[] nm = new Scanner(System.in).next().split(":");
		long gcm = gcm(Long.parseLong(nm[0]), Long.parseLong(nm[1]));
		System.out.printf("%d:%d", Long.parseLong(nm[0]) / gcm, Long.parseLong(nm[1]) / gcm);
	}

	private static long gcm(long a, long b) {
		return b == 0 ? a : gcm(b, a % b);
	}
}