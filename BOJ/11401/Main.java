/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.23
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11401
 */

import java.util.Scanner;

public class Main {

	private static final int MODULAR = 1000000007;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();

		int t = Math.min(n - k, k);
		long f = 1, i = 2;
		for (; i <= t; i++)
			f = (f * i) % MODULAR;

		long kf = f;
		t = Math.max(n - k, k);
		for (; i <= t; i++)
			f = (f * i) % MODULAR;
		kf = (kf * f) % MODULAR;

		for (; i <= n; i++)
			f = (f * i) % MODULAR;
		System.out.print((f * get(kf, MODULAR - 2)) % MODULAR);
	}

	private static long get(long kf, long m) {
		long result = 1;
		while (m != 0) {
			if ((m & 1) != 0)
				result = (result * kf) % MODULAR;
			kf = (kf * kf) % MODULAR;
			m >>= 1;
		}
		return result;
	}
}